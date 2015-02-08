package com.ffbit.algorithms.graph;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphShadExampleWithMultipleConnectedComponents;
import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphShadExampleWithSingularConnectedComponent;
import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphWikipediaExampleWithSingularConnectedComponent;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UndirectedGraphCycleCounterTest {
    private UndirectedGraphCycleCounter cycleCounter;

    @Test
    @Parameters(method = "graphsWithCycles")
    public void itShouldCountCycles(
            UndirectedGraph graph, int expectedCyclesCount
    ) {
        cycleCounter = new UndirectedGraphCycleCounter(graph);

        assertThat(cycleCounter.cyclesCount(), is(expectedCyclesCount));
    }

    private Object[] graphsWithCycles() {
        return new Object[][]{
                {undirectedGraphWikipediaExampleWithSingularConnectedComponent(), 1},
                {undirectedGraphShadExampleWithSingularConnectedComponent(), 4},
                {undirectedGraphShadExampleWithMultipleConnectedComponents(), 1},
                {new UndirectedListGraph(2), 0}
        };
    }

}
