package com.ffbit.algorithms.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class UndirectedGraphTest {
    private UndirectedGraph graph = createUndirectedGraph(4);

    protected abstract UndirectedGraph createUndirectedGraph(int vertices);

    @Test
    public void itShouldHaveNumberOfVerticesSetOnCreation() {
        assertThat(graph.vertices(), is(4));
    }

    @Test
    public void vertexShouldBeConnectedToItselfByReflexiveLaw() {
        assertThat(graph.isConnected(0, 0), is(true));
    }

    @Test
    public void vertexShouldNotBeConnectedToOtherVertexWhenCreated() {
        assertThat(graph.isConnected(0, 1), is(false));
    }

    @Test
    public void vertexShouldBeConnectedToOtherVertexIfTheyWereConnectedByCommutativeLaw() {
        graph.connect(0, 1);

        assertThat("expected 0 to be connected to 1",
                graph.isConnected(0, 1), is(true));
        assertThat("expected 1 to be connected to 0",
                graph.isConnected(1, 0), is(true));
    }

    @Test
    public void itShouldHaveZeroNumberOfAgesWhenCreated() {
        assertThat(graph.ages(), is(0));
    }

    @Test
    public void itShouldCountNumberOfAgesWhenVerticesAreConnected() {
        graph.connect(0, 1);

        assertThat("expected one age", graph.ages(), is(1));

        graph.connect(2, 3);

        assertThat("expected two ages", graph.ages(), is(2));

        graph.connect(2, 0);

        assertThat("expected tree ages", graph.ages(), is(3));
    }

    @Test
    public void itShouldNotCountDuplicatingAgesBetweenAlreadyConnectedVertices() {
        graph.connect(0, 1);

        graph.connect(0, 1);

        assertThat(graph.ages(), is(1));
    }

    @Test
    public void vertexShouldNotHaveAnyConnectedVerticesWhenCreated() {
        assertThat(graph.connections(0), is(empty()));
    }

    @Test
    public void itShouldProvideConnectedVerticesToAGivenVertex() {
        graph.connect(0, 1);
        graph.connect(0, 3);

        assertThat(graph.connections(0), containsInAnyOrder(1, 3));
    }

    @Test
    public void vertexShouldHaveZeroDegreeWhenCreated() {
        assertThat(graph.degree(0), is(0));
    }

    @Test
    public void vertexShouldHaveDegreeOfDistinctConnectedVertices() {
        graph.connect(0, 1);
        graph.connect(0, 1);
        graph.connect(0, 3);

        assertThat(graph.degree(0), is(2));
    }

}
