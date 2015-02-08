package com.ffbit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Directed_graph">Directed graph</a>
 * @see <a href="http://en.wikipedia.org/wiki/Graph_%28mathematics%29#Directed_graph">Graph - Directed graph</a>
 * @see <a href="http://en.wikipedia.org/wiki/Adjacency_matrix">Adjacency matrix</a>
 */
public class DirectedMatrixGraph implements DirectedGraph {
    private final int vertices;
    private final boolean[][] adjacencyMatrix;
    private int ages;

    public DirectedMatrixGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new boolean[vertices][vertices];
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

        adjacencyMatrix[v][u] = true;
        ages++;
    }

    @Override
    public boolean isConnected(int v, int u) {
        return v == u || adjacencyMatrix[v][u];
    }

    @Override
    public Collection<Integer> connections(int v) {
        Collection<Integer> connections = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[v][i]) {
                connections.add(i);
            }
        }

        return connections;
    }

    @Override
    public int degree(int v) {
        return connections(v).size();
    }
}
