package com.ffbit.algorithms.graph;

public class UndirectedMatrixGraphTest extends UndirectedGraphTest {

    @Override
    protected UndirectedGraph createUndirectedGraph(int vertices) {
        return new UndirectedMatrixGraph(vertices);
    }

}
