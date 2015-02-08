package com.ffbit.algorithms.graph;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Box_Drawing">Box Drawing</a>
 * for used drawing symbols.
 */
public class GraphExamples {

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
     */
    public static UndirectedGraph undirectedGraphWikipediaExampleWithSingularConnectedComponent() {
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
     */
    public static UndirectedGraph undirectedGraphShadExampleWithSingularConnectedComponent() {
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

    /**
     * <pre>
     *  0───2 1   5
     *   ╲ ╱   ╲
     *    3     4
     * </pre>
     */
    public static UndirectedGraph undirectedGraphShadExampleWithMultipleConnectedComponents() {
        UndirectedGraph graph = new UndirectedListGraph(6);

        graph.connect(0, 2);
        graph.connect(0, 3);
        graph.connect(2, 3);

        graph.connect(1, 4);

        return graph;
    }

}
