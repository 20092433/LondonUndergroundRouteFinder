package com.example.londonundergroundroutefinder;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CostedPath {
    public  ArrayList<GraphNode<?>> pathList = new ArrayList<>();
    //public String pathCost;
    //private Clipboard pathList;
    public int pathCost;

    public static <T> CostedPath findCheapestPathDijkstra(GraphNode<?> startNode, T lookingfor){
        CostedPath cp=new CostedPath(); //Create result object for cheapest path
        List<GraphNode<?>> encountered=new ArrayList<>(), unencountered=new ArrayList<>(); //Create encountered/unencountered lists
        startNode.nodeValue=0; //Set the starting node value to zero
        unencountered.add(startNode); //Add the start node as the only value in the unencountered list to start
        GraphNode<?> currentNode;
        do{ //Loop until unencountered list is empty
            currentNode=unencountered.remove(0); //Get the first unencountered node (sorted list, so will have lowest value)
            encountered.add(currentNode); //Record current node in encountered list
            if(currentNode.data.equals(lookingfor)){ //Found goal - assemble path list back to start and return it
                cp.pathList.add(currentNode); //Add the current (goal) node to the result list (only element)
                cp.pathCost=currentNode.nodeValue; //The total cheapest path cost is the node value of the current/goal node
                while(currentNode!=startNode) { //While we're not back to the start node...
                    boolean foundPrevPathNode=false; //Use a flag to identify when the previous path node is identified
                    for(GraphNode<?> n : encountered) { //For each node in the encountered list...
                        for(GraphNode e : n.adjlist) //For each edge from that node...
                            if(e==currentNode && currentNode.nodeValue-1==n.nodeValue){ //If that edge links to the
                                //current node and the difference in node values is the cost of the edge -> found path node!
                                cp.pathList.add(0,n); //Add the identified path node to the front of the result list
                                currentNode=n; //Move the currentNode reference back to the identified path node
                                foundPrevPathNode=true; //Set the flag to break the outer loop
                                break; //We've found the correct previous path node and moved the currentNode reference
                                //back to it so break the inner loop
                            }
                        if(foundPrevPathNode) break; //We've identified the previous path node, so break the inner loop to continue
                    }
                }
                //Reset the node values for all nodes to (effectively) infinity so we can search again (leave no footprint!)
                for(GraphNode<?> n : encountered) n.nodeValue=Integer.MAX_VALUE;
                for(GraphNode<?> n : unencountered) n.nodeValue=Integer.MAX_VALUE;
                return cp; //The costed (cheapest) path has been assembled, so return it!
            }
            //We're not at the goal node yet, so...
            for(GraphNode e : currentNode.adjlist) //For each edge/link from the current node...
                if(!encountered.contains(e)) { //If the node it leads to has not yet been encountered (i.e. processed)
                    e.nodeValue=Integer.min(e.nodeValue, currentNode.nodeValue+1); //Update the node value at the end
                    //of the edge to the minimum of its current value or the total of the current node's value plus the cost of the edge
                    if(!unencountered.contains(e)) unencountered.add(e);
                }
            Collections.sort(unencountered,(n1, n2)->n1.nodeValue-n2.nodeValue); //Sort in ascending node value order
        }while(!unencountered.isEmpty());
        return null; //No path found, so return null
    }
}
