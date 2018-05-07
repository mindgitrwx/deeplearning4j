package org.deeplearning4j.graph.api;

import lombok.AllArgsConstructor;
import Vertex.java;

public class Vertex_equals(Vertex<?> data, Object o){
    boolean compare(){
        if (!(o instanceof Vertex))
            return false;
        Vertex<?> v = (Vertex<?>) o;
        if (data.vertexID() != v.vertexID())
            return false;
        if ((data.getValue() == null && v.getValue() != null) || (data.getValue() != null && v.getValue() == null))
            return false;
        return data.getValue() == null || data.getValue().equals(v.getValue());
    }
}