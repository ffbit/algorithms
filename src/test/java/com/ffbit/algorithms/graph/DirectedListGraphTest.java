package com.ffbit.algorithms.graph;

public class DirectedListGraphTest extends DirectedGraphTest {

    @Override
    protected DirectedGraph createGraph(int vertices) {
        return new DirectedListGraph(vertices);
    }

}
