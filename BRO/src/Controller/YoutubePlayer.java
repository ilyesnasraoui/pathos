/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.stage.Stage;

public class YoutubePlayer extends Application {
  public static void main(String[] args) throws Exception { launch(args); }
  @Override public void start(final Stage stage) throws Exception {
    final MediaPlayer oracleVid = new MediaPlayer(
      new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv")
    );
    stage.setScene(new Scene(new Group(new MediaView(oracleVid)), 540, 208));
    stage.show();

    oracleVid.play();
  }
}