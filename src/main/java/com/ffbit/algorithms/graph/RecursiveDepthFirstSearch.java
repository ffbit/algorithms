package com.ffbit.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Depth-first_search">Depth-first search</a>
 */
public class RecursiveDepthFirstSearch {
    private final UndirectedGraph graph;
    private final boolean[] visited;
    private final List<Integer> traversalPath = new ArrayList<>();

    public RecursiveDepthFirstSearch(UndirectedGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.vertices()];
        dfs();
    }

    private void dfs() {
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!visited[vertex]) {
                dfs(vertex);
            }
        }
    }

    private void dfs(int vertex) {
        traversalPath.add(vertex);
        visited[vertex] = true;

        for (int connection : graph.connections(vertex)) {
            if (!visited[connection]) {
                dfs(connection);
            }
        }
    }

    public List<Integer> traversal() {
        return traversalPath;
    }

}
