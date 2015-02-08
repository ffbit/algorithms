package com.ffbit.algorithms.graph;

public class UndirectedListGraphTest extends UndirectedGraphTest {

    @Override
    protected UndirectedGraph createGraph(int vertices) {
        return new UndirectedListGraph(vertices);
    }

}
