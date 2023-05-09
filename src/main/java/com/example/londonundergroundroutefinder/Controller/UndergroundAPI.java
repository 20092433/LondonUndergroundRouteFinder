package com.example.londonundergroundroutefinder.Controller;

import com.example.londonundergroundroutefinder.CostedPath;
import com.example.londonundergroundroutefinder.GraphNode;
import com.example.londonundergroundroutefinder.SearchGraph;
import com.example.londonundergroundroutefinder.Station;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.londonundergroundroutefinder.CostedPath.findCheapestPathDijkstra;

public class UndergroundAPI implements Initializable {


    public ImageView mapView;
   // public  start;
    public ComboBox destination;
    public ComboBox stationBox;
    public ComboBox destBox;
    public TextArea routeView;
    private List<GraphNode<Station>> stationsList;

    Station selected;

    public UndergroundAPI() {
//        this.stationsList = new LinkedList<>();
//        readCSV();
//        oneToOneConnection();
    }

    public void populateTextView() {
        String src = stationBox.getSelectionModel().getSelectedItem().toString();
        GraphNode<Station> srcnode = findGraphNodeByName(src);
        String dest = destBox.getSelectionModel().getSelectedItem().toString();
        Station destStation = ((Station)findGraphNodeByName(dest).data);

//        routeView.clear();
//        routeView.getId().toString().equals(destnode.adjlist);
        //String temp = "Solution path from "+ srcnode.data.getStationName() +" to node containing " + destStation.getStationName() + "\n";

        //System.out.println("Solution path from "+ srcnode.data.getStationName() +" to node containing " + destStation.getStationName());
        System.out.println("--------------------------------------------------------");
        String thePath = "";
        List<GraphNode<?>> path= SearchGraph.findPathDepthFirst(srcnode,null,destStation);
        for(GraphNode<?> n : path) {
            System.out.println(n.data);
            thePath += ((Station)n.data).getStationName() + "\n";
        }

        String temp = "Solution path from "+ srcnode.data.getStationName() +" to node containing " + destStation.getStationName() + "\n" +
                "the path between both is" + "\n" + thePath;

        routeView.setText(temp);
        //routeView.setText(path);



        //hello hope this updated



//        if (stationBox.getItems().toString().equals(stationsList) && destBox.getItems().toString().equals(stationsList)){
//
//
//        }


    }


    public void routeViewCheapest(){
        String srcc = stationBox.getSelectionModel().getSelectedItem().toString();
        GraphNode<Station> srcnode = findGraphNodeByName(srcc);
        String destt = destBox.getSelectionModel().getSelectedItem().toString();
        Station destStation = ((Station)findGraphNodeByName(destt).data);

        routeView.clear();
        String DA =("The cheapest path from" + srcnode.data.getStationName() + "\n" +
                        "to" + destStation.getStationName() + "using Dijkstra's algorithm:");
        //System.out.println("using Dijkstra's algorithm:");
        //System.out.println("-------------------------------------");
        String thePathh = "";
        CostedPath cpa=findCheapestPathDijkstra(srcnode,destStation);
        for(GraphNode<?> n : cpa.pathList) {
            System.out.println(n.data);
            thePathh += ((Station) n.data).getStationName() + "\n";
        }
        routeView.setText(DA + "\nThe total path cost is: "+ cpa.pathCost + "the path you need to take is " + thePathh);
    }


    
    public void initialise() {
        this.stationsList = new LinkedList<>();
        readCSV();
        oneToOneConnection();
        // ChoiceBox<String> stationBox = new ChoiceBox<>();
        //for loop
        //add each station name
        //add node data station name from node data
        //stationBox.getItems().addAll(stationsList);

        for (int i = 0; i < stationsList.size(); i++) {
            stationBox.getItems().add(stationsList.get(i).data.getStationName());
        }



        for (int i = 0; i < stationsList.size(); i++){
            destBox.getItems().add(stationsList.get(i).data.getStationName());
        }





    }


    public void randomiseRoute(){



    }

//    public void cheapestPathConnection(){
//        System.out.println("The cheapest path from Silver to Gold");
//        System.out.println("using Dijkstra's algorithm:");
//        System.out.println("-------------------------------------");
//        CostedPath cpa=findCheapestPathDijkstra(n,"Gold");
//        for(GraphNode<?> n : cpa.pathList)
//            System.out.println(n.data);
//        System.out.println("\nThe total path cost is: "+cpa.pathCost);
//    }






    public void oneToOneConnection(){
        System.out.println("Solution path from Acton Town to node containing bond street");
        System.out.println("--------------------------------------------------------");
        List<GraphNode<?>> path= SearchGraph.findPathDepthFirst(stationsList.get(8),null,stationsList.get(25).data);
        for(GraphNode<?> n : path) System.out.println(n.data);
    }
    private void readCSV() {
        String stationFileLine;
        File stationsFile = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/LondonUndergroundData.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(stationsFile))) {
            while ((stationFileLine = br.readLine()) != null) {
                String[] elements = stationFileLine.split(",");
                Station s = new Station(Integer.parseInt(elements[0]), Double.parseDouble(elements[1]), Double.parseDouble(elements[2]), elements[3], elements[4], elements[5], Integer.parseInt(elements[6]), Integer.parseInt(elements[7]));
                GraphNode<Station> stations = new GraphNode<>(s);
                stationsList.add(stations);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String routesFileLine;
        File routesFile = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/test.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(routesFile))) {
            while ((routesFileLine = br.readLine()) != null) {
                String[] elements = routesFileLine.split(",");
                System.out.println(elements[0]);
                GraphNode<Station> src = findGraphNodeById(Integer.parseInt(elements[0].trim()));
                GraphNode<Station> dest = findGraphNodeById(Integer.parseInt(elements[1].trim()));
                if (src != null && dest != null)
                    src.connectToNodeUndirected(dest);
                //Routes r = new Routes(Integer.parseInt(elements[0]), elements[1], elements[2], elements[3]);
                // GraphNode<Routes> routes = new GraphNode<>(r);
                //routesList.add(routes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        printAllGraphNodes();
    }

    public GraphNode<Station> findGraphNodeById(int id) {

        for (GraphNode<Station> node : stationsList){
            if (((Station) node.data).getId() == id) {
                return node;
            }
    }
        return null;
    }
    public GraphNode<Station> findGraphNodeByName(String n) {

        for (GraphNode<Station> node : stationsList){
            if (((Station) node.data).getStationName().equals(n) ) {
                return node;
            }
        }
        return null;
    }

    private void printAllGraphNodes() {
        for (GraphNode<Station> node : stationsList) {

            System.out.println(node.data);
            System.out.println("Next Stations");
            System.out.println("_______________________________________________________________");
            for(GraphNode<Station> otherStations: node.adjlist){

                System.out.println(otherStations.data);
            }
            System.out.println("_________________________________________________________________________");

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.stationsList = new LinkedList<>();
        readCSV();
        oneToOneConnection();
        // ChoiceBox<String> stationBox = new ChoiceBox<>();
        //for loop
        //add each station name
        //add node data station name from node data
        //stationBox.getItems().addAll(stationsList);

        for (int i = 0; i < stationsList.size(); i++){
            stationBox.getItems().add(stationsList.get(i).data.getStationName());
        }

        for (int i = 0; i < stationsList.size(); i++){
            destBox.getItems().add(stationsList.get(i).data.getStationName());
        }


        //if (destBox.getItems().toString().equals(stationsList))
    }
}

