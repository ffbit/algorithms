package com.ffbit.algorithms.graph;

public class UndirectedMatrixGraphTest extends UndirectedGraphTest {

    @Override
    protected UndirectedGraph createGraph(int vertices) {
        return new UndirectedMatrixGraph(vertices);
    }

}
