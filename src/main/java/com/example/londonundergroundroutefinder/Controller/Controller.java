package com.example.londonundergroundroutefinder.Controller;
import com.example.londonundergroundroutefinder.SearchGraph;
import com.example.londonundergroundroutefinder.GraphNode;
import com.example.londonundergroundroutefinder.Routes;
import com.example.londonundergroundroutefinder.Station;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

import java.io.*;
import java.lang.annotation.ElementType;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    ImageView mapView;

    @FXML
    ToggleButton depthFirstSearch, startPos, destinationPos;

    @FXML
    ComboBox<String> start, destination;

    private List<GraphNode<Routes>> routesList;

    private List<GraphNode<Station>> stationsList;

    public Controller() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }





    /*
    private void readCSV() {
        String fileLine;
        File file = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/Routes.csv");
try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    while ((fileLine = br.readLine()) != null) {
        String[] elements = fileLine.split("");
        Routes r = new Routes(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3]);
        ArrayList<Routes> routes = null;
        routes.add(r);
        routesList.add(r);
    }

} catch (IOException e) {
    e.printStackTrace();
}
        // Read Stations.csv file
        String stationsFileLine;
        File stationsFile = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/LondonUndergroundData.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(stationsFile));
            while ((stationsFileLine = br.readLine()) != null) {
                String[] elements = stationsFileLine.split(",");
                Station s = new Station(Integer.parseInt(elements[0]), Double.parseDouble(elements[1]),Double.parseDouble(elements[2]), elements[3], elements[4], Integer.parseInt(elements[5]), Integer.parseInt(elements[6]), Integer.parseInt(elements[7]));
                GraphNode<Station> stations = new GraphNode<>(s);



                // Parse the elements from the line and create Station objects
                // Add Station objects to appropriate data structure or perform required operations
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    }
