package com.ffbit.algorithms.graph;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Graph_%28mathematics%29#Undirected_graph">Graph - Undirected graph</a>
 * @see <a href="http://en.wikipedia.org/wiki/Adjacency_list">Adjacency list</a>
 */
public class UndirectedListGraph implements UndirectedGraph {
    private final int vertices;
    private final Set<Integer>[] adjacencyList;
    private int ages;

    @SuppressWarnings("unchecked")
    public UndirectedListGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = (Set<Integer>[]) new Set[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedHashSet<>();
        }
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int ages() {
        return ages;
    }

    @Override
    public void connect(int v, int u) {
        if (isConnected(v, u)) {
            return;
        }

        adjacencyList[v].add(u);
        adjacencyList[u].add(v);
        ages++;
    }

    @Override
    public boolean isConnected(int v, int u) {
        return v == u || adjacencyList[v].contains(u);
    }

    @Override
    public Collection<Integer> connections(int v) {
        return new LinkedHashSet<>(adjacencyList[v]);
    }

    @Override
    public int degree(int v) {
        return adjacencyList[v].size();
    }

}
