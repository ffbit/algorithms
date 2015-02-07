package com.ffbit.algorithms.graph;

public class IterativeDepthFirstSearchTest extends DepthFirstSearchTest {

    @Override
    DepthFirstSearch createDepthFirstSearch(UndirectedGraph graph) {
        return new IterativeDepthFirstSearch(graph);
    }

}
