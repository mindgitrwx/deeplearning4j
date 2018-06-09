package org.deeplearning4j.graph.api;

import lombok.Data;
import Edge_equals.java;
import Edge_hashCode.java;
import Edge_toString.java;
/** Edge in a graph. May be a directed or undirected edge.<br>
 * Parameterized, and may store a value/object associated with the edge
 */
@Data
public class Edge<T> {

    private final int from;
    private final int to;
    private final T value;
    private final boolean directed;

    public Edge(int from, int to, T value, boolean directed) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.directed = directed;
    }

    public int getFrom(){
        return from;
    }

    public int getTo(){
        return to;
    }

    public T getValue(){
        return value;
    }

    public boolean getDirected(){
        return directed;
    }

    @Override
    public String toString() {
        Edge_toString String_changer = new Edge_toString(this);
        return String_changer.getString();
    }

    @Override
    public boolean equals(Object o) {
        Edge_equals Compare = new Edge_equals(this, o);
        return Compare.compare();
    }

    @Override
    public int hashCode() {
        Edge_hashCode result = new Edge_hashCode(this);
        return result.return_hashCode();
    }
}

