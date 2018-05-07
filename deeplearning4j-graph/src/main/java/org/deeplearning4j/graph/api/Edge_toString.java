package org.deeplearning4j.graph.api;

import lombok.Data;
import Edge.java;

public class Edge_toString(Edge<T> data){
    String getString(){
        String direction = "directed";
        String connection_type = "-->";

        if(data.getDirected() == false){
            direction = "undirected";
            connection_type = "--";
        }
        return "edge(" + direction + "," + data.getFrom() + connection_type + data.getTo() + "," + (data.getValue() != null ? data.getValue() : "") + ")";
    }
}