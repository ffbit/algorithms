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
public class ConnectedComponentsTest {
    private ConnectedComponents componentCounter;

    @Test
    @Parameters(method = "graphsWithConnectedComponentCounts")
    public void itShouldShouldCountAllConnectedComponents(
            UndirectedGraph graph, int expectedConnectedComponentCount
    ) {
        componentCounter = new ConnectedComponents(graph);

        assertThat(
                componentCounter.connectedComponents(),
                is(expectedConnectedComponentCount)
        );
    }

    private Object[] graphsWithConnectedComponentCounts() {
        return new Object[][]{
                {undirectedGraphWikipediaExampleWithSingularConnectedComponent(), 1},
                {undirectedGraphShadExampleWithSingularConnectedComponent(), 1},
                {undirectedGraphShadExampleWithMultipleConnectedComponents(), 3}
        };
    }

}
