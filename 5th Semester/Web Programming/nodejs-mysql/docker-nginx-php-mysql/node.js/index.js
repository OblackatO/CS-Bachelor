  var express = require('express'),
      mysql = require('mysql'),
      http = require('http'),
      jsSHA = require("jssha"),
      WebSocket = require('ws'),
      fs = require('fs')

  //Connections and setup
  /*************************************************/
  //lib to handle body os POST request with express.
  const bodyParser = require('body-parser');
  var app = express();
  app.use(
    bodyParser.urlencoded({
      extended: true
    })
  )
  app.use(bodyParser.json());

  var con = mysql.createConnection({
    host: "10.7.1.2",
    user: "webprog",
    password: "webprog",
    database: "webprog"
  });
  con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
  });
  /*************************************************/

  function generate_random(length) {
    /* This random generating function was taken from:
     * https://stackoverflow.com/questions/1349404/generate-random-string-characters-in-javascript
     * This is not Plagiarism -.- 
    */
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }

  //Request routes
  /********************************************************/
  app.get('/', function(req, res, next) {
    res.sendFile(__dirname+'/HtmlPages/MainPage.html');
  });

  app.get('/MainFeed', function(req, res, next) {
    res.sendFile(__dirname+'/HtmlPages/MainFeed.html');
  });
  

  app.get('/Register', function(req, res, next) {
    res.sendFile(__dirname+'/HtmlPages/Register.html');
  });

  app.post('/SessionValidation', function(req, res, next) {
    const add_user = `SELECT client_username FROM SESSIONS WHERE session_id = "${req.body.session_id}"`
    con.query(add_user, function (err, result) {
        var data = JSON.stringify(result);
        if (err){
          console.log("Error in session validation.");
          res.send("Invalid");
        }else if(data != "[]"){
            console.log("value of data on server:"+data);
            console.log("")
            res.send("Session established. May connect to websocket!");
        }else{
            res.send("Invalid");
        }
    });
  });

  app.post('/RegisterUser', function(req, res, next) {
    console.log(`Data received:${req.body.username}`)
    var table = "";
    if(req.body.type === "Student"){
        table = "STUDENT";
    }else{
        table = "LECTURER";
    }
    const add_user = `INSERT INTO ${table} (username, pwd) VALUES ("${req.body.username}", "${req.body.password}")`
    con.query(add_user, function (err, result) {
        if (err){
            if(String(err).includes("Duplicate entry")){
                res.send("EXISTS");
            }else{
                res.send("ERROR");
            }
        }
        res.send("OK");
    });
  });

  app.post('/Login', function(req, res, next) {
    const random_server_secret = generate_random(24);
    console.log("sending to client:"+random_server_secret);
    data = {"server_secret":random_server_secret};
    const init_session = `INSERT INTO SESSIONS (client_username, client_secret, server_secret) VALUES ("${req.body.username}", "${req.body.secret}", "${random_server_secret}")`
    con.query(init_session, function (err, result) {
        if (err){
          if(String(err).includes("Duplicate entry")){
            res.send("ALREADY ESTABLISHED.")
          }
          console.log("error occured for putting data in sessions");
          throw err;
        }
        res.send(JSON.stringify(data));
    });
  });

  app.post('/LoginStep2', function(req, res, next) {
    var password_value = "";
    console.log("LoginStep2 username:"+req.body.username);
    con.query(`SELECT pwd FROM STUDENT WHERE username = "${req.body.username}"`, function (err, result, fields) {
        var data = JSON.stringify(result);
        console.log("username data:"+data);
        if(data != "[]"){
            user_pwd = JSON.parse(data.replace("[", "").replace("]", ""));
            password_value = user_pwd.pwd;
            console.log("password:"+password_value);
        }else{
            con.query(`SELECT pwd FROM LECTURER WHERE username = "${req.body.username}"`, function (err, result, fields) {
                var data = JSON.stringify(result);
                user_pwd = JSON.parse(data.replace("[", "").replace("]", ""));
                password_value = user_pwd.pwd;
            });
        }
    });

    con.query(`SELECT * FROM SESSIONS WHERE client_username = "${req.body.username}"`, function (err, result, fields) {
        if (err) throw err;
        var user_data = JSON.stringify(result);
        //console.log("user data:"+user_data);
        user = JSON.parse(user_data.replace("[", "").replace("]", ""));
        //console.log("user secret:"+user.client_secret);
        //console.log("LoginStep2 all fields result:"+JSON.stringify(result));
        //console.log("Values before hashing on server: \npwd:"+password_value);
        //console.log("server secret:"+user.server_secret);
        //console.log("client secret:"+user.client_secret);
        const to_hash = user.client_secret+password_value+user.server_secret;
        console.log("text about to be hashed on server:"+to_hash);
        var shaObj = new jsSHA("SHA-256", "TEXT");
        shaObj.update(to_hash);
        var hash = shaObj.getHash("HEX");
        if(hash == req.body.hash){
            console.log("Hashes match!");
            /*Code to generate unique ID. Taken from: 
            **https://stackoverflow.com/questions/105034/create-guid-uuid-in-javascript/ 
            */
            var lut = []; for (var i=0; i<256; i++) { lut[i] = (i<16?'0':'')+(i).toString(16); }
            var d0 = Math.random()*0xffffffff|0;
            var d1 = Math.random()*0xffffffff|0;
            var d2 = Math.random()*0xffffffff|0;
            var d3 = Math.random()*0xffffffff|0;
            const final =  lut[d0&0xff]+lut[d0>>8&0xff]+lut[d0>>16&0xff]+lut[d0>>24&0xff]+'-'+
            lut[d1&0xff]+lut[d1>>8&0xff]+'-'+lut[d1>>16&0x0f|0x40]+lut[d1>>24&0xff]+'-'+
            lut[d2&0x3f|0x80]+lut[d2>>8&0xff]+'-'+lut[d2>>16&0xff]+lut[d2>>24&0xff]+
            lut[d3&0xff]+lut[d3>>8&0xff]+lut[d3>>16&0xff]+lut[d3>>24&0xff];
            /***********************************************************************/
            console.log("session_id"+final);
            const init_session = `UPDATE SESSIONS SET session_id = "${final}" WHERE client_username = "${req.body.username}"`
            con.query(init_session, function (err, result) {
              if (err){
                res.send("not done");
              }
              res.send(JSON.stringify({"session_id":final}));
            });
        }else{
            console.log("Hashes not ok!");
            console.log("client hash:"+req.body.hash);
            console.log("server hash:"+hash);
            res.send("not done");
        }
     });
  });
  /********************************************************/

  /** CSS Styles' routes && JSscripts && Other links. 
    * Browser requests them on the fly.
  ***/
  /************************************************/
  app.get('/Styles/LoginStyles.css', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/LoginStyles.css');
  });

  app.get('/Styles/RegisterStyles.css', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/RegisterStyles.css');
  });

  app.get('/Styles/MainFeedStyle.css', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/MainFeedStyle.css');
  });

  app.get('/Styles/MainFeedPostStyle.css', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/MainFeedPostStyle.css');
  });

  app.get('/Styles/ViewPostStyle.css', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/ViewPostStyle.css');
  });

  app.get('/favicon.ico', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/favicon.ico');
  });
  
  //Background picture
  app.get('/Styles/belval.png', function(req, res, next) {
    res.sendFile(__dirname+'/Styles/belval.png');
  });

  app.get('/JSScripts/js_sha256.js', function(req, res, next) {
    res.sendFile(__dirname+'/JSScripts/js_sha256.js');
  });
  /*************************************************/

  //Http Server
  const server = http.createServer(app);
  var clients = [];

  //Web socket server
  /* After the login the html pages are updated with content 
   * that is transmited by websockets and dinamically updated
   * on the HTML page it self.  
   */ 
  /*******************************************************/
  const wss = new WebSocket.Server({ server });
  wss.on('connection', function connection(ws) {
    
    clients.push(ws)
    ws.isAlive = true;
    ws.on('pong', heartbeat);
    ws.on('message', function incoming(message) {
      
      if(message == "MainFeedPost"){
        console.log("Client required MainFeedPost.")
        fs.readFile('HtmlPages/DynamicHtmlParts/MainFeedPost.html', 'utf8', function(err, data) {
          if (err) throw err;
          ws.send(JSON.stringify({"MainFeedPost":data}))
        });
      
      }else if(message == "MainFeed"){
        console.log("Client required MainFeed.")
        fs.readFile('HtmlPages/DynamicHtmlParts/MainFeed.html', 'utf8', function(err, data) {
          if (err) throw err;
          ws.send(JSON.stringify({"MainFeed":data}))
        });
      
      }else if(message == "GET ALL POSTS"){
        console.log("GET ALL POSTS received.");
        con.query(`SELECT * FROM STAGES`, function (err, result, fields) {
          if(JSON.stringify(result) == "[]"){
            to_send_data = {"POSTS": "None"}
            //console.log("data about to be sent:"+to_send_data)
            ws.send(JSON.stringify(to_send_data));
          }else{
            to_send_data = {"POSTS":JSON.stringify(result)}
            //console.log("data about to be sent"+to_send_data)
            ws.send(JSON.stringify(to_send_data))
          }
        });
      
      }else if(message.includes("NEW_POST")){
        post_parsed = JSON.parse(message)
        console.log("Post info:"+post_parsed.NEW_POST.name)
        insert_query = `
          INSERT INTO STAGES (name, description, company, start_date, end_date)
          VALUES 
          (
            "${post_parsed.NEW_POST.name}", 
            "${post_parsed.NEW_POST.description}", 
            "${post_parsed.NEW_POST.company_name}",
            DATE("${post_parsed.NEW_POST.start_date}"),
            DATE("${post_parsed.NEW_POST.end_date}")
          )
          `
        con.query(insert_query, function (err, result, fields) {
          if(err){
            console.log("Error occured inserting new post.");
            throw err;
          }
        });
      
      }else if(message.includes("session_id")){
        session_id = JSON.parse(message)
        console.log("Received disconnection from:"+session_id.session_id)
        delete_query = `DELETE FROM SESSIONS WHERE session_id = "${session_id.session_id}"`
        con.query(delete_query, function (err, result, fields) {
          if(err){
            console.log("Error occured deleting session.");
            throw err;
          }else{
            ws.send("DISCONNECTION OK")
          }
        });
      
      }else if(message.includes("GET_POST_INFO")){
        info_parsed = JSON.parse(message)
        order = info_parsed.order
        post_id = info_parsed.id
        fs.readFile('HtmlPages/DynamicHtmlParts/ViewPost.html', 'utf8', function(err, data) {
          if (err) throw err;
          //console.log('OK: ');
          //console.log(data)
          select_query = `SELECT * FROM STAGES WHERE id = "${post_id}"`
          con.query(select_query, function (err, result, fields) {
            if(err){
              console.log("Error occured deleting session.");
              throw err;
            }else{
              //ws.send("DISCONNECTION OK")
              console.log("data about selected post:"+result)
              post_data = {"POST_PRESENTATION":data, "POST_INFO":result}
              ws.send(JSON.stringify(post_data))
            }
          });
        });
      
      }else if(message.includes("user_session") && message.includes("stage_id")){
        /* Code used to the "follow" procedure. 
         * User should click on a button "follow" and he would be added to 
         * the SUBSCRIPTIONS table in the database.  
         * Button not implemented in the interface.
         */ 
        message_parsed = JSON.parse(message)
        console.log("SOMEONE WANTS TO FOLLOW")
        select_query = `SELECT client_username FROM SESSIONS WHERE session_id = "${message_parsed.user_session}"`
        con.query(select_query, function (err, result, fields) {
          if(err){
            console.log("Error adding sub session.");
            throw err;
          }else{
            console.log("result:"+JSON.stringify(result))
            var username = JSON.stringify(result).replace("[", "").replace("]", "")
            username = JSON.parse(username).client_username
            insert_query = `INSERT INTO SUBSCRIPTIONS (username, stage_id) VALUES ("${username}", "${message_parsed.stage_id}")`
            con.query(insert_query, function (err, result, fields) {
              if(err){
                console.log("Error occured while adding sub.")
                throw err
              }
            });
          }
        });  
      
      }else if(message.includes("chat_message")){
        chat_message_parsed = JSON.parse(message);
        console.log("Chat message:"+chat_message_parsed.chat_message)
        console.log("Internship_name:"+chat_message_parsed.internship_name)
        console.log("session_id:"+chat_message_parsed.session_chat_id)
        select_query = `SELECT client_username FROM SESSIONS WHERE session_id = "${chat_message_parsed.session_chat_id}"`
        con.query(select_query, function (err, result, fields) {
          if(err){
            console.log("Error occured deleting session.");
            throw err;
          }else{
            var result_parsed = JSON.stringify(result).replace("[", "").replace("]", "")
            result_parsed = JSON.parse(result_parsed);
            to_send = {
              "chat_message":chat_message_parsed.chat_message, 
              "internship_name":chat_message_parsed.internship_name,
              "user":result_parsed.client_username
            }
            //console.log("result:"+JSON.stringify(result))
            //console.log("fields:"+JSON.stringify(fields))
            /* Broadcasts some message to all connected clients 
            */
            for(i=0; i<clients.length; i++){
              clients[i].send(JSON.stringify(to_send))
            }
          }
        });
      }
    });
  });
  /*******************************************************/

  function noop() {}

  function heartbeat() {
    console.log("In heartbeat function of server")
    this.isAlive = true;
  }

  /* Periodically sends for every connected client a ping request to avoid
   * closing the websocket connection.
   */
  const interval = setInterval(function ping() {
    wss.clients.forEach(function each(ws) {
      if (ws.isAlive === false) return ws.terminate();
      ws.isAlive = false;
      ws.ping(noop);
    });
  }, 3000);

  server.listen(process.env.PORT || 8080, function() {
    console.log('Listening on port ' + (process.env.PORT || 8080));
  });