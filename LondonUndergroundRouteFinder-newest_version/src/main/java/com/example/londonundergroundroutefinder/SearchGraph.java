package com.example.londonundergroundroutefinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchGraph {
    //Recursive depth-first search of graph (first single path identified returned)
    //
    public static <T> List<GraphNode<?>> findPathDepthFirst(GraphNode<?> from, List<GraphNode<?>> encountered, T lookingfor){
        List<GraphNode<?>> result;
        if(from.data.equals(lookingfor)) { //Found it
            result=new ArrayList<>(); //Create new list to store the path info (any List implementation could be used)
            result.add(from); //Add the current node as the only/last entry in the path list
            return result; //Return the path list
        }
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        Collections.shuffle(from.adjlist);
        for(GraphNode<?> adjNode : from.adjlist)
            if(!encountered.contains(adjNode)) {
                result=findPathDepthFirst(adjNode,encountered,lookingfor);
                if(result!=null) { //Result of the last recursive call contains a path to the solution node
                    result.add(0,from); //Add the current node to the front of the path list
                    return result; //Return the path list
                }

            }
        return null;
    }



}
