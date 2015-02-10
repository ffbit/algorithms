package com.ffbit.algorithms.graph;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DirectedGraphLoopCounterTest {
    private DirectedGraphLoopCounter loopCounter;

    @Test
    @Parameters(method = "graphs")
    public void itShouldCountCycles(
            DirectedGraph graph, int expectedLoopsCount
    ) {
        loopCounter = new DirectedGraphLoopCounter(graph);

        assertThat(loopCounter.loopsCount(), is(expectedLoopsCount));
    }

    private Object[] graphs() {
        return new Object[][]{
                {threeAgesGraphWithLoop(), 1},
                {threeAgesGraphWithoutLoop(), 0},
                {sixAgesGraphWithOneLoop(), 1},
                {sixAgesGraphWithTwoLoops(), 2},
                {sixAgesGraphWithoutLoop(), 0},
        };
    }

    /**
     * <pre>
     *     0
     *    ↗ ↘
     *   1←──2
     * </pre>
     */
    private DirectedGraph threeAgesGraphWithLoop() {
        DirectedGraph graph = new DirectedListGraph(3);

        graph.connect(0, 2);
        graph.connect(2, 1);
        graph.connect(1, 0);

        return graph;
    }

    /**
     * <pre>
     *     0
     *    ↙ ↘
     *   1──→2
     * </pre>
     */
    private DirectedGraph threeAgesGraphWithoutLoop() {
        DirectedGraph graph = new DirectedListGraph(3);

        graph.connect(0, 1);
        graph.connect(0, 2);
        graph.connect(1, 2);

        return graph;
    }

    /**
     * <pre>
     *     0
     *    ↙ ↘
     *   1   2
     *   ⇅  ↙ ↘
     *   3 4   5
     * </pre>
     */
    private DirectedGraph sixAgesGraphWithOneLoop() {
        DirectedGraph graph = new DirectedListGraph(6);

        graph.connect(0, 1);
        graph.connect(0, 2);

        graph.connect(1, 3);
        graph.connect(3, 1);

        graph.connect(2, 4);
        graph.connect(2, 5);

        return graph;
    }

    /**
     * <pre>
     *     0
     *    ↙ ↘
     *   1   2
     *   ⇅  ↙ ↖
     *   3 4──→5
     * </pre>
     */
    private DirectedGraph sixAgesGraphWithTwoLoops() {
        DirectedGraph graph = new DirectedListGraph(6);

        graph.connect(0, 1);
        graph.connect(0, 2);

        graph.connect(1, 3);
        graph.connect(3, 1);

        graph.connect(2, 4);
        graph.connect(4, 5);
        graph.connect(5, 2);

        return graph;
    }

    /**
     * <pre>
     *     0
     *    ↙ ↘
     *   1   2
     *   ↓  ↙ ↘
     *   3 4──→5
     * </pre>
     */
    private DirectedGraph sixAgesGraphWithoutLoop() {
        DirectedGraph graph = new DirectedListGraph(6);

        graph.connect(0, 1);
        graph.connect(0, 2);

        graph.connect(1, 3);

        graph.connect(2, 4);
        graph.connect(2, 5);

        return graph;
    }

}
