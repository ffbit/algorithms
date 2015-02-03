package com.ffbit.algorithms.buffer;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OverridingCircularBufferTest {
    private OverridingCircularBuffer<Integer> buffer;

    @Before
    public void setUp() throws Exception {
        buffer = new OverridingCircularBuffer<>(4);
    }

    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(buffer.isEmpty(), is(true));
    }

    @Test
    public void itShouldHaveZeroSizeWhenCreated() {
        assertThat(buffer.size(), is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void itShouldNotAllowToReadFromEmptyBuffer() {
        buffer.read();
    }

    @Test
    public void itShouldNotBeEmptyIfAnElementWasAdded() {
        buffer.write(2);

        assertThat(buffer.isEmpty(), is(false));
    }

    @Test
    public void itShouldHaveOneSizeIfOneElementWasWritten() {
        buffer.write(2);

        assertThat(buffer.size(), is(1));
    }

    @Test
    public void itShouldAllowToReadAnElementAfterItWasWritten() {
        buffer.write(1);

        assertThat(buffer.read(), is(1));
    }

    @Test
    public void itShouldAllowToReadElementsInOrderAfterTheyWereWritten() {
        buffer.write(1);
        buffer.write(2);

        assertThat("the first read element mismatch", buffer.read(), is(1));
        assertThat("the second read element mismatch", buffer.read(), is(2));
    }

    @Test
    public void itShouldDecreaseSizeWhenElementWasRead() {
        buffer.write(1);
        buffer.write(2);

        buffer.read();

        assertThat(buffer.size(), is(1));
    }

    @Test
    public void itShouldBeEmptyAfterAllWrittenElementsWereRead() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);

        buffer.read();
        buffer.read();
        buffer.read();

        assertThat(buffer.isEmpty(), is(true));
    }

    @Test
    public void itShouldOverrideOldestElementsWhenCapacityExceeded() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        buffer.write(4);

        buffer.write(5);

        assertThat("the first read element mismatch", buffer.read(), is(2));
        assertThat("the second read element mismatch", buffer.read(), is(3));
        assertThat("the third read element mismatch", buffer.read(), is(4));
        assertThat("the fourth read element mismatch", buffer.read(), is(5));
    }

    @Test
    public void sizeShouldNotExceedCapacityWhenOldestElementsAreOverridden() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        buffer.write(4);

        buffer.write(5);

        assertThat(buffer.size(), is(4));
    }

    @Test
    public void itShouldAllowToWriteAfterOldestElementsWereOverriddenAndWritten() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        buffer.write(4);
        buffer.write(5);
        buffer.read();
        buffer.read();
        buffer.read();

        buffer.write(6);

        assertThat("the first read element mismatch", buffer.read(), is(5));
        assertThat("the second read element mismatch", buffer.read(), is(6));
    }

}
