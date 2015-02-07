package com.ffbit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Depth-first_search">Depth-first search</a>
 */
public class IterativeDepthFirstSearch implements DepthFirstSearch {
    private final UndirectedGraph graph;
    private final boolean[] visited;
    private final List<Integer> traversalPath;

    public IterativeDepthFirstSearch(UndirectedGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.vertices()];
        traversalPath = new ArrayList<>(graph.vertices());

        dfs();
    }

    private void dfs() {
        Deque<Integer> stack = new LinkedList<>();
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            dfs(vertex, stack);
        }
    }

    private void dfs(int vertex, Deque<Integer> stack) {
        stack.push(vertex);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            traversalPath.add(v);

            for (int u : reverse(graph.connections(v))) {
                if (!visited[u]) {
                    stack.push(u);
                }
            }
        }
    }

    private Collection<Integer> reverse(Collection<Integer> connections) {
        List<Integer> result = new ArrayList<>(connections);
        Collections.reverse(result);

        return result;
    }

    @Override
    public List<Integer> traversal() {
        return traversalPath;
    }

}
