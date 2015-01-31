package com.ffbit.algorithms.list;

import com.ffbit.algorithms.list.ReverseSinglyLinkedList.ListNode;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ReverseSinglyLinkedListTest {
    private ReverseSinglyLinkedList listReverser =
            new ReverseSinglyLinkedList();

    @Test
    @Parameters(method = "data")
    public void itShouldReverseLinkedListIteratively(ListNode<?> list,
                                                     ListNode<?> reversedList) {
        assertThat(listReverser.reverse(list), is(reversedList));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldReverseLinkedListRecursively(ListNode<?> list,
                                                     ListNode<?> reversedList) {
        assertThat(listReverser.reverseRecursively(list), is(reversedList));
    }

    Object[][] data() {
        return new Object[][]{
                {new ListNode<>(1), new ListNode<>(1)},
                {new ListNode<>(1, new ListNode<>(2)),
                        new ListNode<>(2, new ListNode<>(1))},
                {new ListNode<>(1, new ListNode<>(2, new ListNode<>(3))),
                        new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)))},
        };
    }

}
