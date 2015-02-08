package com.ffbit.algorithms.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Cycle_%28graph_theory%29">Cycle (graph theory)</a>
 */
public class UndirectedGraphCycleCounter {
    private final boolean[] visited;
    private final int[] predecessors;
    private int cyclesCount;

    public UndirectedGraphCycleCounter(UndirectedGraph graph) {
        visited = new boolean[graph.vertices()];
        predecessors = new int[graph.vertices()];
        Arrays.fill(predecessors, -1);

        dfs(graph);
    }

    private void dfs(UndirectedGraph graph) {
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!isVisited(vertex)) {
                dfs(vertex, graph);
            }
        }
    }

    private void dfs(int vertex, UndirectedGraph graph) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (isVisited(v)) {
                continue;
            }

            visited[v] = true;

            for (int u : graph.connections(v)) {
                if (!isVisited(u)) {
                    stack.push(u);
                    predecessors[u] = v;
                } else if (predecessors[v] != u) {
                    cyclesCount++;
                }
            }
        }
    }

    private boolean isVisited(int vertex) {
        return visited[vertex];
    }

    public int cyclesCount() {
        return cyclesCount;
    }

}
