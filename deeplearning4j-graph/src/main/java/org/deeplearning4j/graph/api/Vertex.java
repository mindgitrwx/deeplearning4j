package org.deeplearning4j.graph.api;

import lombok.AllArgsConstructor;

/** Vertex in a graph
 *
 * @param <T> the type of the value/object associated with the vertex
 */
@AllArgsConstructor
public class Vertex<T> {

    private final int idx;
    private final T value;

    public int vertexID() {
        return idx;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "vertex(" + vertexID() + "," + (getValue() != null ? getValue() : "") + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex))
            return false;
        Vertex<?> v = (Vertex<?>) o;
        if (vertexID() != v.vertexID())
            return false;
        if ((getValue() == null && v.getValue() != null) || (getValue() != null && v.getValue() == null))
            return false;
        return value == null || getValue().equals(v.getValue());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + vertexID();
        result = 31 * result + (getValue() == null ? 0 : getValue().hashCode());
        return result;
    }
}
