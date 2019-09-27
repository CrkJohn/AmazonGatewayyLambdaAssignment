package edu.escuelaing.arem.firstWorkshop;

import static spark.Spark.*;
import java.util.*;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.text.*;

public class Application{


    public static void main(String[] args)  throws IOException  { 
        port(getPort());
        String first  =  getFileFromResources("index.html");
        get("/", (req, res) -> first);    
        post("calculo" , (req,res) -> {
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            int ans  = Integer.parseInt(jsonObject.get("num").getAsString());
            String urlStirng ="https://ka3u2xe90g.execute-api.us-east-1.amazonaws.com/AREM?value="+ans;
            URL url = new URL(urlStirng);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine().trim();    
        });
    }   
    

    static int getPort() {   
        if (System.getenv("PORT") != null) { 
            return Integer.parseInt(System.getenv("PORT"));  
        }        
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)   
    }
    /**
     * 
     * @param fileName nombre de archivo html
     * @return retorna como string el contenido del  html con nombre file name
     * @throws IOException
     */
    static String getFileFromResources(String fileName)  throws IOException  {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String html = "";
        while(bf.ready()){
            html+=bf.readLine();
        }
        return html;

    }


}