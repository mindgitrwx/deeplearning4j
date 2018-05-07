package org.deeplearning4j.graph.api;

import lombok.Data;
import Edge.java;

public class Edge_equals(Edge<?> data, Object o){

    boolean compare(){
        if (!(o instanceof Edge))
            return false;
        Edge<?> e = (Edge<?>) o;

        if (data.getDirected() != e.getDirected())
            return false;

        if (data.getDirected()) {
            if (data.getFrom() != e.getFrom())
                return false;
            if (data.getTo() != e.getTo())
                return false;
        } else {
            if (data.getFrom() == e.getFrom()) {
                if (data.getTo() != e.getTo())
                    return false;
            } else {
                if (data.getFrom() != e.getTo())
                   return false;
                if (data.getTo() != e.getFrom())
                   return false;
            }
        }

        if ((data.getValue() != null && e.getValue() == null) || (data.getValue() == null && e.getValue() != null))
            return false;

        return data.getValue() == null || data.getValue().equals(e.getValue());}
}