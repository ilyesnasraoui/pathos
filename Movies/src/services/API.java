/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import model.Movie;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import java.net.HttpURLConnection;
import java.net.URI;

import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author elyes
 */
public class API {
    
    
   private static JsonArray movies;
    
  private static HttpURLConnection connection;
      public static void main(String[] args) throws IOException, InterruptedException {
      API api=new API("justice");
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
       String json = gson.toJson(movies.get(1));
      //parseInt(movies.get(0).getAsJsonObject().get("id").toString())
      int idFilm = parseInt(movies.get(0).getAsJsonObject().get("id").toString());
        int idCat = 1;
        String language = movies.get(0).getAsJsonObject().get("original_language").toString();
        String nom = movies.get(0).getAsJsonObject().get("original_title").toString();
                
        int duree = 120;
      String image="https://image.tmdb.org/t/p/w500"+ movies.get(0).getAsJsonObject().get("poster_path").toString();
        String desc = movies.get(0).getAsJsonObject().get("overview").toString();
        String utube = "frefer";
        String date = movies.get(0).getAsJsonObject().get("original_title").toString();
        float rated = parseFloat(movies.get(0).getAsJsonObject().get("vote_average").toString());
        Movie m = new Movie(idFilm, duree, idCat, nom, language, image, desc,utube,date,rated); 

              //Movie(int idFilm, int duree, int idCat, String nom, String lang, String imgUrl, String desc,String utube,String date,int rated)
      }


    public API(String s) throws IOException, InterruptedException {
        
        var client= HttpClient.newBuilder().build();
       /* var URL="https://cineinfo.p.rapidapi.com/v1/movies/5f92ecbc69e2832f8c167bdb"+s;
        var request= HttpRequest.newBuilder().uri(URI.create(URL)).header("x-rapidapi-key", "fbd95f80femsh42c684caa42828cp1c2664jsnc2be3f60cf5f").header("x-rapidapi-host", "cineinfo.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
*/
       s=s.replace(" ","%20");
         var URL="https://api.themoviedb.org/3/search/multi?api_key=ba9007874ae1b197d4fa0574fabba170&language=en&query="+s+"&page=1&include_adult=false&fbclid=IwAR08vpervb55VV8BsOuMpsIsfgxxkH_NJDGz1okpdkB20pvNg1vYdw82NVg";
        var request= HttpRequest.newBuilder().uri(URI.create(URL)).method("GET", HttpRequest.BodyPublishers.noBody()).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

		
		
JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String json = gson.toJson(jsonObject.get("results"));



  this.movies= jsonObject.get("results").getAsJsonArray(); 
    }

    /**
     * @param args the command line arguments
     */
    public ArrayList<Movie> getMovie(){
            ArrayList<Movie> lss = new ArrayList<Movie>();

           
        for (int i = 0;  3>i; i++)
    {
  
           int idFilm = parseInt(movies.get(i).getAsJsonObject().get("id").toString());
        int idCat = 1;
        String language = movies.get(i).getAsJsonObject().get("original_language").toString();
        String nom = null;
        /*if(movies.get(i).getAsJsonObject().get("original_title").toString() == "")
            nom="test";    */ 
        try{
            nom=movies.get(i).getAsJsonObject().get("original_title").toString();
        }
        catch (Exception e)
        {
            System.out.println("title undefined");
        }
        int duree = 120;
       String imageName =movies.get(i).getAsJsonObject().get("poster_path").toString();
      String image="https://image.tmdb.org/t/p/w500" + imageName.substring( 1, imageName.length() - 1 ) ;
      System.out.println(image);
      String utube = "regerg";
        String date = movies.get(i).getAsJsonObject().get("release_date").toString();
        System.out.println(date);
        float rated = parseFloat(movies.get(i).getAsJsonObject().get("vote_average").toString());
        String desc = movies.get(i).getAsJsonObject().get("overview").toString();
        Movie m = new Movie(idFilm, duree, idCat, nom, language, image, desc,utube,date,rated); 
        lss.add(m);
      
    }
        System.out.println(lss.toString());
       return lss;
            }
    }
    

