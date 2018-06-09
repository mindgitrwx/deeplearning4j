package org.deeplearning4j.graph.models;

/** Binary tree interface, used in DeepWalk */
public interface BinaryTree {
    void buildTree(int[] vertexDegree);

    int getMaxCodeLength();

    long getCode(int element);

    int getCodeLength(int element);

    String getCodeString(int element);

    int[] getPathInnerNodes(int element);
}
