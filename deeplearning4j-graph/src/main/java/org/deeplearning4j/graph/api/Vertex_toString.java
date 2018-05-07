package org.deeplearning4j.graph.api;

import lombok.AllArgsConstructor;
import Vertex.java;

public class Vertex_toString(Vertex<?> data){
    String return_string(){
        return "vertex(" + data.vertexID() + "," + (data.getValue() != null ? data.getValue() : "") + ")";
    }
}