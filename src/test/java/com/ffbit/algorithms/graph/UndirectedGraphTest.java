package com.ffbit.algorithms.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class UndirectedGraphTest extends GraphTest {

    @Override
    protected abstract UndirectedGraph createGraph(int vertices);

    @Test
    public void vertexShouldBeConnectedToOtherVertexIfTheyWereConnectedByCommutativeLaw() {
        graph.connect(0, 1);

        assertThat("expected 0 to be connected to 1",
                graph.isConnected(0, 1), is(true));
        assertThat("expected 1 to be connected to 0",
                graph.isConnected(1, 0), is(true));
    }

}
