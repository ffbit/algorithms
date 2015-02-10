package com.ffbit.algorithms.graph;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Directed_graph">Directed graph</a>
 */
public class Arc {
    private int tail;
    private int head;

    public Arc(int tail, int head) {
        this.tail = tail;
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public int getHead() {
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Arc)) {
            return false;
        }

        Arc that = (Arc) o;

        return tail == that.tail
                && head == that.head;
    }

    @Override
    public int hashCode() {
        int result = tail;
        result = 31 * result + head;
        return result;
    }

    @Override
    public String toString() {
        return tail + " -> " + head;
    }

}
