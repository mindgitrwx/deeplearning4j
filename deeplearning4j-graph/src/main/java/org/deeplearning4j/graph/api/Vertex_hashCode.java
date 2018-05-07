package org.deeplearning4j.graph.api;

import lombok.AllArgsConstructor;
import Vertex.java;

public Vertex_hashCode(Vertex<?> data){
    int return_hashcode(){
        int result = 17;
        result = 31 * result + data.vertexID();
        result = 31 * result + (data.getValue() == null ? 0 : data.getValue().hashCode());
        return result;
    }
}