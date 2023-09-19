package com.example.londonundergroundroutefinder;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T data;
    public int nodeValue = Integer.MAX_VALUE;

    public List<GraphNode<T>> adjlist = new ArrayList<>();

    public GraphNode(T data) {
        this.data=data;
    }
    public void connectToNodeDirected(GraphNode<T> destNode) {
        adjlist.add(destNode);
    }
    public void connectToNodeUndirected(GraphNode<T> destNode) {
        adjlist.add(destNode);
        destNode.adjlist.add(this);
    }



}
