package com.example.londonundergroundroutefinder;

import java.util.ArrayList;
import java.util.List;

public class Graph {
 /*   //Recursive depth-first search of graph (first single path identified returned)
    public static <T> List<GraphNode<?>> findPathDepthFirst(GraphNode<?> from, List<GraphNode<?>> startNode, T lookingfor) {
        List<List<GraphNode<?>>> result;
        if (from.data.equals(lookingfor)) {
            result = new ArrayList<>();
            result.add(from);
            return result;
        }
        if (startNode == null) startNode = new ArrayList<>(); //First node so create new (empty) startNode list
        startNode.add(from);
        for (GraphNode<?> adjNode : from.adjList)
            if (!startNode.contains(adjNode)) {
                result = findPathDepthFirst(adjNode, startNode, lookingfor);
                if (result != null) {
                    result.add(0, from);
                    return result;
                }
            }
        return null;
    }*/
}
