package org.deeplearning4j.graph.api;

import lombok.Data;
import Edge.java;

public class Edge_hashCode(Edge<T> data){
    int return_hashCode(){
        int result = 17;
        result = 31 * result + (data.getDirected() ? 1 : 0);
        result = 31 * result + data.getFrom();
        result = 31 * result + data.getTo();
        result = 31 * result + (data.getValue() == null ? 0 : data.getValue().hashCode());
        return result;
    }
}