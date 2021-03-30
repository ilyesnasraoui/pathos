/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoogleMaps;

import Entités.Evenement;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;

import com.lynden.gmapsfx.javascript.object.*;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
//import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author PersoPc
 */
public class GoogleMapBike extends Application implements MapComponentInitializedListener {

  GoogleMapView mapView;
GoogleMap map;
final WebView  webView = new WebView();
    @Override
    public void start(Stage stage) throws Exception {

       webView.getEngine().load("https://www.google.com/maps/@37.0372627,10.0823753,11z");

    Scene scene = new Scene(webView);

    stage.setTitle("Google Maps ArtLife");
    stage.setScene(scene);
    stage.show();
    
    }

  @Override
 public void mapInitialized() {
    //Set the initial properties of the map.
    MapOptions mapOptions = new MapOptions();

    mapOptions.center(new LatLong(47.6097, -122.3331))
            
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(12);

    map = mapView.createMap(mapOptions);

    //Add a marker to the map
   /* MarkerOptions markerOptions = new MarkerOptions();

    markerOptions.position( new LatLong(47.6, -122.3) )
                .visible(Boolean.TRUE)
                .title("My Marker");

    Evenement evenement = new Evenement( markerOptions );

   // map.addMarker(evenement);
     */
}

public static void main(String[] args) {
    launch(args);
}
    
}
