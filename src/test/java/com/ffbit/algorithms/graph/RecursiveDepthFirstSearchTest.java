package com.ffbit.algorithms.graph;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RecursiveDepthFirstSearchTest {

    @Test
    @Parameters(method = "undirectedGraphsWithSingleConnectedComponent")
    public void itShouldTraverseUndirectedGraphWithOneConnectedComponent(
            UndirectedGraph graph, List<Integer> traversalPath
    ) {
        RecursiveDepthFirstSearch dfs = new RecursiveDepthFirstSearch(graph);

        assertThat(dfs.traversal(), is(traversalPath));
    }

    @Test
    @Parameters(method = "undirectedGraphsWithMultipleConnectedComponents")
    public void itShouldTraverseUndirectedGraphWithMultipleConnectedComponents(
            UndirectedGraph graph, List<Integer> traversalPath
    ) {
        RecursiveDepthFirstSearch dfs = new RecursiveDepthFirstSearch(graph);

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

    /**
     * <pre>
     *     0
     *    ╱│╲
     *   1 2 4
     *  ╱│ │ │
     * 3 5 6 │
     *   └───┘
     * </pre>
     *
     * @see <a href="http://en.wikipedia.org/wiki/Depth-first_search#Example">Depth-first search - Example</a>
     * @see <a href="http://en.wikipedia.org/wiki/Box_Drawing">Box Drawing</a>
     * for used drawing symbols.
     */
    private UndirectedGraph undirectedGraphWikipediaExampleWithSingularConnectedComponent() {
        UndirectedGraph graph = new UndirectedListGraph(7);

        graph.connect(0, 1);
        graph.connect(0, 2);
        graph.connect(0, 4);
        graph.connect(1, 3);
        graph.connect(1, 5);
        graph.connect(2, 6);
        graph.connect(5, 4);

        return graph;
    }

    /**
     * <pre>
     *  0──1──┐
     *  │  │  │
     *  6──2──8
     *  │  │  │
     *  5──3──7
     *     │
     *     4
     * </pre>
     *
     * @see <a href="http://en.wikipedia.org/wiki/Box_Drawing">Box Drawing</a>
     * for used drawing symbols.
     */
    private UndirectedGraph undirectedGraphShadExampleWithSingularConnectedComponent() {
        UndirectedGraph graph = new UndirectedListGraph(9);

        graph.connect(0, 1);
        graph.connect(0, 6);
        graph.connect(1, 2);
        graph.connect(1, 8);
        graph.connect(2, 3);
        graph.connect(2, 6);
        graph.connect(2, 8);
        graph.connect(3, 4);
        graph.connect(3, 5);
        graph.connect(3, 7);
        graph.connect(5, 6);
        graph.connect(7, 8);

        return graph;
    }

    private Object[][] undirectedGraphsWithMultipleConnectedComponents() {
        return new Object[][]{
                {undirectedGraphShadExampleWithMultipleConnectedComponents(),
                        Arrays.asList(0, 2, 3, 1, 4, 5)}
        };
    }

    /**
     * <pre>
     *  0───2 1   5
     *   ╲ ╱   ╲
     *    3     4
     * </pre>
     *
     * @see <a href="http://en.wikipedia.org/wiki/Box_Drawing">Box Drawing</a>
     * for used drawing symbols.
     */
    private UndirectedGraph undirectedGraphShadExampleWithMultipleConnectedComponents() {
        UndirectedGraph graph = new UndirectedListGraph(6);

        graph.connect(0, 2);
        graph.connect(0, 3);
        graph.connect(2, 3);

        graph.connect(1, 4);

        return graph;
    }

}
