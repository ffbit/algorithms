package com.ffbit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Graph_%28mathematics%29#Undirected_graph">Graph - Undirected graph</a>
 * @see <a href="http://en.wikipedia.org/wiki/Adjacency_matrix">Adjacency matrix</a>
 */
public class UndirectedMatrixGraph {
    private final int vertices;
    private final boolean[][] adjacencyMatrix;
    private int ages;

    public UndirectedMatrixGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new boolean[vertices][vertices];
    }

    public int vertices() {
        return vertices;
    }

    public int ages() {
        return ages;
    }

    public boolean isConnected(int v, int u) {
        return v == u
                || adjacencyMatrix[v][u] && adjacencyMatrix[u][v];
    }

    public void connect(int v, int u) {
        if (isConnected(v, u)) {
            return;
        }

        adjacencyMatrix[v][u] = true;
        adjacencyMatrix[u][v] = true;
        ages++;
    }

    public Collection<Integer> connections(int v) {
        Collection<Integer> connections = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[v][i] && v != i) {
                connections.add(i);
            }
        }

        return connections;
    }

    public int degree(int v) {
        return connections(v).size();
    }

}
