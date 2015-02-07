package com.ffbit.algorithms.graph;

public class RecursiveDepthFirstSearchTest extends DepthFirstSearchTest {

    DepthFirstSearch createDepthFirstSearch(UndirectedGraph graph) {
        return new RecursiveDepthFirstSearch(graph);
    }

}
