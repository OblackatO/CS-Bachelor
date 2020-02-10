var express = require('express'),
    http = require('http'),
    os = require('os'),
    redis = require('redis');

var app = express();

console.log(process.env.REDIS_PORT_6379_TCP_ADDR + ':' + process.env.REDIS_PORT_6379_TCP_PORT);
var client = redis.createClient('6379', 'redis');

app.get('/', function(req, res, next) {
  client.incr('counter', function(err, counter) {
    if(err) return next(err);
    console.log("Access done on " + os.hostname());
    res.send('This page has been viewed ' + counter + ' times!<br/><br/>' +
        'Using node ' + os.hostname());
  });
});

app.get('/ex2', function(req,res,next) {
  res.send("<p>This is a toy example on a different URL</p>");
});

http.createServer(app).listen(process.env.PORT || 8080, function() {
  console.log('Listening on port ' + (process.env.PORT || 8080));
});
