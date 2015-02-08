package com.ffbit.algorithms.graph;

public class DirectedMatrixGraphTest extends DirectedGraphTest {

    @Override
    protected DirectedGraph createGraph(int vertices) {
        return new DirectedMatrixGraph(vertices);
    }

}
