package com.ffbit.algorithms.graph;

import static org.junit.Assert.*;

public class UndirectedListGraphTest extends UndirectedGraphTest {

    @Override
    protected UndirectedGraph createUndirectedGraph(int vertices) {
        return new UndirectedListGraph(vertices);
    }

}
