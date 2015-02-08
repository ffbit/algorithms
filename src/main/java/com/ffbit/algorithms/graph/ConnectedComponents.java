package com.ffbit.algorithms.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Connected_component_%28graph_theory%29">Connected component (graph theory)</a>
 */
public class ConnectedComponents {
    private final boolean[] visited;
    private int connectedComponents;

    public ConnectedComponents(UndirectedGraph graph) {
        visited = new boolean[graph.vertices()];
        dfs(graph);
    }

    private void dfs(UndirectedGraph graph) {
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!visited[vertex]) {
                connectedComponents++;
                dfs(vertex, graph);
            }
        }
    }

    private void dfs(int vertex, UndirectedGraph graph) {
        Deque<Integer> stack = new LinkedList<>();
        dfs(vertex, stack, graph);
    }

    private void dfs(int vertex, Deque<Integer> stack, UndirectedGraph graph) {
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (visited[v]) {
                continue;
            }

            visited[v] = true;

            for (int u : graph.connections(v)) {
                if (!visited[u]) {
                    stack.push(u);
                }
            }
        }
    }

    public int connectedComponents() {
        return connectedComponents;
    }

}
