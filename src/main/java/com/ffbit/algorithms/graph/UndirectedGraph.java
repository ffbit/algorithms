package com.ffbit.algorithms.graph;

import java.util.Collection;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Graph_%28mathematics%29#Undirected_graph">Graph - Undirected graph</a>
 */
public interface UndirectedGraph {

    int vertices();

    int ages();

    void connect(int v, int u);

    boolean isConnected(int v, int u);

    Collection<Integer> connections(int v);

    int degree(int v);

}
