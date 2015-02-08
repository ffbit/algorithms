package com.ffbit.algorithms.graph;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphShadExampleWithMultipleConnectedComponents;
import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphShadExampleWithSingularConnectedComponent;
import static com.ffbit.algorithms.graph.GraphExamples.undirectedGraphWikipediaExampleWithSingularConnectedComponent;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class DepthFirstSearchTest {

    @Test
    @Parameters(method = "undirectedGraphsWithSingleConnectedComponent")
    public void itShouldTraverseUndirectedGraphWithOneConnectedComponent(
            UndirectedGraph graph, List<Integer> traversalPath
    ) {
        DepthFirstSearch dfs = createDepthFirstSearch(graph);

        assertThat(dfs.traversal(), is(traversalPath));
    }

    abstract DepthFirstSearch createDepthFirstSearch(UndirectedGraph graph);

    @Test
    @Parameters(method = "undirectedGraphsWithMultipleConnectedComponents")
    public void itShouldTraverseUndirectedGraphWithMultipleConnectedComponents(
            UndirectedGraph graph, List<Integer> traversalPath
    ) {
        DepthFirstSearch dfs = createDepthFirstSearch(graph);

        assertThat(dfs.traversal(), is(traversalPath));
    }

    private Object[][] undirectedGraphsWithSingleConnectedComponent() {
        return new Object[][]{
                {undirectedGraphWikipediaExampleWithSingularConnectedComponent(),
                        Arrays.asList(0, 1, 3, 5, 4, 2, 6)},
                {undirectedGraphShadExampleWithSingularConnectedComponent(),
                        Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8)}
        };
    }

    private Object[][] undirectedGraphsWithMultipleConnectedComponents() {
        return new Object[][]{
                {undirectedGraphShadExampleWithMultipleConnectedComponents(),
                        Arrays.asList(0, 2, 3, 1, 4, 5)}
        };
    }

}
