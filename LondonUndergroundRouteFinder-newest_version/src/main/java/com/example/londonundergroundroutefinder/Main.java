package com.example.londonundergroundroutefinder;

import com.example.londonundergroundroutefinder.Controller.UndergroundAPI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends  Application{
   // @Override
   public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GUI/route_finder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1254, 747);
        stage.setTitle("London Underground Route Finder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
      launch(args);
       new UndergroundAPI();


   }
       // launch();
//        String file = "C:\\Users\\A\\OneDrive - Waterford Institute of Technology\\data structures\\LondonUndergroundRouteFinder\\src\\main\\resources\\com\\example\\londonundergroundroutefinder\\CSV\\Routes.csv";
//        BufferedReader reader = null;
//        String line = "";
//
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            while((line = reader.readLine()) != null){
//
//                String[] row = line.split(",");
//
//                for(String index : row) {
//                    System.out.printf("%-10s", index);
//                }
//                System.out.println();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}