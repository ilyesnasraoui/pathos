/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Wissem
 */
public class Facebook
{
  
        public user authentificationfb()
        {
       String domain  ="http%3A%2F%2Flocalhost%2F";
        String appId="771103457134012";
        
        String authUrl="https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=email,public_profile";
                
                
                
         System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         
         WebDriver driver =new ChromeDriver();
         driver.get(authUrl);
         String accessToken="EAAK9UIOlxbwBAKUZCQomnBIb00YUTIyd6lgoxag6FL4OjP2xVfL7DxZCPY8CZCfILMgstMJprheWKyb5ZBq52wkHc9SnvQAIe55hETBKOb67VD7zRbl51scVIvqoupNBhy0WR1QROHEdb2IxIvZB0dODUywQC5wKfkmyxDggG7OzPcdpTj0vUuPmQoXqMnS41rlDkmYTNyffwofZBNj6hZBf04R6OaZCNwBlxC9YwAlfZCBW04eKoaJFZB";
         
         while (true){
             if(!driver.getCurrentUrl().contains("facebook.com")){
                 String url=driver.getCurrentUrl();
                 //accessToken=url.replaceAll(".*#access_token=(.+)&.*", "$1");
                 driver.quit();
                 
                FacebookClient fbClient= new DefaultFacebookClient(accessToken, Version.UNVERSIONED);
                User me= fbClient.fetchObject("me",User.class);
               String email ="wissem22111@gmail.com";
        //String email=me.getEmail();
        //System.out.println(email+"aaaferef");
        
        String name = me.getName();
        System.err.println(name);
        String password = "";
         user u = new user(name, password,email);  
          return u;      
             }
           
            
             
         }
        }
}

