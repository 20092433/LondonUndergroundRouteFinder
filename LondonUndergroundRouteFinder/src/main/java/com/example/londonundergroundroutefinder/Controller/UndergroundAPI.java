package com.example.londonundergroundroutefinder.Controller;

import com.example.londonundergroundroutefinder.GraphNode;
import com.example.londonundergroundroutefinder.Station;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UndergroundAPI {

    private List<GraphNode<Station>> stationsList;

    public UndergroundAPI() {
        this.stationsList = new LinkedList<>();
        readCSV();
    }

    private void readCSV() {
        String stationFileLine;
        File stationsFile = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/LondonUndergroundData.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(stationsFile))) {
            while ((stationFileLine = br.readLine()) != null) {
                String[] elements = stationFileLine.split(",");
                Station s = new Station(Integer.parseInt(elements[0]), Double.parseDouble(elements[1]), Double.parseDouble(elements[2]), elements[3], elements[4], Integer.parseInt(elements[5]), Integer.parseInt(elements[6]), Integer.parseInt(elements[7]));
                GraphNode<Station> stations = new GraphNode<>(s);
                stationsList.add(stations);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String routesFileLine;
        File routesFile = new File("src/main/resources/com/example/londonundergroundroutefinder/CSV/LineDef.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(routesFile))) {
            while ((routesFileLine = br.readLine()) != null) {
                String[] elements = routesFileLine.split(",");
                GraphNode<Station> src = findGraphNodeById(elements[0]);
                GraphNode<Station> dest = findGraphNodeById(elements[1]);
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
    }

    public GraphNode<Station> findGraphNodeById(String id) {
        for (GraphNode<Station> node : stationsList) {
            if (node.equals(id)) {
                return node;
            }
        }
        return null;
    }


}
