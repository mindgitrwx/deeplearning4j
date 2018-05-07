package org.deeplearning4j.graph.api;

import lombok.AllArgsConstructor;
import Vertex_toString.java;
import Vertex_equals.java;
import Vertex_hashCode.java;

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
        Vertex_toString String_changer = new Vertex_toString(this);
        return String_changer.return_string();
    }

    @Override
    public boolean equals(Object o) {
        Vertex_equals Compare = new Vertex_equals(this, o);
        return Compare.compare();
    }

    @Override
    public int hashCode() {
        Vertex_hashCode result = new Vertex_hashCode(this);
        return result.return_hashcode();
    }
}
