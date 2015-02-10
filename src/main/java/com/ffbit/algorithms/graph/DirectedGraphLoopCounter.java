package com.ffbit.algorithms.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Cycle_%28graph_theory%29">Cycle (graph theory)</a>
 */
public class DirectedGraphLoopCounter {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private final int[] colors;
    private int loopsCount;

    public DirectedGraphLoopCounter(DirectedGraph graph) {
        colors = new int[graph.vertices()];
        dfs(graph);
    }

    private void dfs(DirectedGraph graph) {
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (isWhite(vertex)) {
                dfs(vertex, graph);
            }
        }
    }

    private void dfs(int vertex, DirectedGraph graph) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(vertex);
        dfs(stack, graph);
    }

    private void dfs(Deque<Integer> stack, DirectedGraph graph) {
        int vertex = stack.pop();
        setGray(vertex);

        for (int u : graph.connections(vertex)) {
            if (isGray(u)) {
                loopsCount++;
            } else if (isBlack(u)) {
                // nothing
            } else {
                stack.push(u);
                dfs(stack, graph);
            }
        }

        setBlack(vertex);
    }

    private boolean isWhite(int vertex) {
        return colors[vertex] == WHITE;
    }

    private void setGray(int vertex) {
        colors[vertex] = GRAY;
    }

    private boolean isGray(int vertex) {
        return colors[vertex] == GRAY;
    }

    private boolean isBlack(int vertex) {
        return colors[vertex] == BLACK;
    }

    private void setBlack(int vertex) {
        colors[vertex] = BLACK;
    }

    public int loopsCount() {
        return loopsCount;
    }

}
