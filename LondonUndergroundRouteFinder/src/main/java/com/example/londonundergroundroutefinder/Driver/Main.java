package com.example.londonundergroundroutefinder.Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{
   // @Override
   /* public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("route_finder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("London Underground Route Finder");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
       // launch();
        String file = "/Users/daniellawton/Downloads/LondonUndergroundRouteFinder/src/CSV/Routes.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){

                String[] row = line.split(",");

                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}