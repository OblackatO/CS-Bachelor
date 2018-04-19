//
//  main.swift
//  Exercise29
//
//  Created by Pedro Gomes  on 19/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

let files_to_serve = ["/about":"about.html", "shadow_file":"shadow_file.txt","Cooking_guide":"Cooking_guide.txt", "secret.gpg":"download.zip"]
let code_files = ["200":" [+]Server Request successful", "404":" [!]File not found", "500":" [!]Internal server error."]
var browsing_history : [String]? = nil



func file_exist(_ request_string: String) -> Bool {
    
    for(key, _) in files_to_serve {
        if key == request_string{return true}
    }
    
    return false
}


func is_HtmlFile(_ request_string: String) -> Bool {
    
    for(key, value) in files_to_serve {
        if key == request_string {
            return value.hasSuffix(".html")
        }
    }
    
    return false
}

func serve ( _ url : String? , _ params : [ String : String ]?) -> ( code : Int , description : String ) {
    
    if params == nil {
        print("Serving static file about", url!)
        return(200, code_files["200"]!)
    }
    
    print("Executing download file with the following parameters.")
    for(key, value) in params! {
        print(key+":"+value)
    }
    
    return(200, code_files["200"]!)
}

func main() {
    
    
    while(true) {
        print("\n[+]Request:"); let scanned_request = readLine()
        if(scanned_request == "exit") {
            break
        }
        
        if is_HtmlFile(scanned_request!) {
            
            if !file_exist(scanned_request!) {
                print("404", code_files["404"]!)
                continue
            }
            
            let result = serve(scanned_request!, nil)
            print(result.code, result.description)
            
        }else if scanned_request == "/Download"{
            print("File to Download:"); let file_to_download = readLine()
            
            if !file_exist(file_to_download!) {
                print("404", code_files["404"]!)
                continue
            }
            
            print("Download mode:"); let download_mode = readLine()
            let result = serve(nil, ["File:":file_to_download!, "Mode:":download_mode!])
            print(result.code, result.description)
            
        }else {
            print("500", code_files["500"]!)
            
        }
    }
}

main()
