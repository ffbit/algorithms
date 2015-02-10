package com.ffbit.algorithms.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class ArcTest {

    @Test
    public void itShouldHaveSetTail() {
        Arc acr = new Arc(1, 2);

        assertThat(acr.getTail(), is(1));
    }

    @Test
    public void itShouldHaveSetHead() {
        Arc arc = new Arc(3, 4);

        assertThat(arc.getHead(), is(4));
    }

    @Test
    public void itShouldHaveReasonableToStringImplementation() {
        Arc arc = new Arc(1, 2);

        assertThat(arc.toString(), is("1 -> 2"));
    }

    @Test
    public void itShouldNotBeEqualToNull() {
        Arc arc = new Arc(1, 2);

        assertThat(arc.equals(null), is(false));
    }

    @Test
    public void verticesWithSameTailAndHeadShouldBeEqual() {
        Arc first = new Arc(1, 2);
        Arc second = new Arc(1, 2);

        assertThat(first, is(second));
    }

    @Test
    public void verticesWithDifferentTailAndSameHeadShouldNotBeEqual() {
        Arc first = new Arc(1, 2);
        Arc second = new Arc(3, 2);

        assertThat(first, is(not(second)));
    }

    @Test
    public void verticesWithSameTailAndDifferentHeadShouldNotBeEqual() {
        Arc first = new Arc(1, 2);
        Arc second = new Arc(1, 3);

        assertThat(first, is(not(second)));
    }

    @Test
    public void verticesWithSameTailAndHeadShouldHaveSameHashCode() {
        Arc first = new Arc(1, 2);
        Arc second = new Arc(1, 2);

        assertThat(first.hashCode(), is(second.hashCode()));
    }

}
