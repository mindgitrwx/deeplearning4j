package org.deeplearning4j.graph.api;

import lombok.Data;
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
        String direction = "directed";
        String connection_type = "-->";

        if(getDirected() == false){
            direction = "undirected";
            connection_type = "--";
        }
        return "edge(" + direction + "," + getFrom() + connection_type + getTo() + "," + (getValue() != null ? getValue() : "") + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Edge))
            return false;
        Edge<?> e = (Edge<?>) o;
        if (getDirected() != e.getDirected())
            return false;
        if (getDirected()) {
            if (getFrom() != e.getFrom())
                return false;
            if (getTo() != e.getTo())
                return false;
        } else {
            if (getFrom() == e.getFrom()) {
                if (getTo() != e.getTo())
                    return false;
            } else {
                if (getFrom() != e.getTo())
                    return false;
                if (getTo() != e.getFrom())
                    return false;
            }
        }
        if ((getValue() != null && e.getValue() == null) || (getValue() == null && e.getValue() != null))
            return false;
        return getValue() == null || getValue().equals(e.getValue());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (getDirected() ? 1 : 0);
        result = 31 * result + getFrom();
        result = 31 * result + getTo();
        result = 31 * result + (getValue() == null ? 0 : getValue().hashCode());
        return result;
    }
}
