package com.ffbit.algorithms.list;

import com.ffbit.algorithms.list.ReverseSinglyLinkedList.ListNode;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReverseSinglyLinkedListTest {
    private ReverseSinglyLinkedList listReverser =
            new ReverseSinglyLinkedList();

    @Test
    public void itShouldReverseLinkedListOfOneNode() {
        ListNode<Integer> list = new ListNode<>(1);
        ListNode<Integer> reversedList = new ListNode<>(1);

        assertThat(listReverser.reverse(list), is(reversedList));
    }

    @Test
    public void itShouldReverseLinkedListOfTwoNodes() {
        ListNode<Integer> list = new ListNode<>(1, new ListNode<>(2));
        ListNode<Integer> reversedList = new ListNode<>(2, new ListNode<>(1));

        assertThat(listReverser.reverse(list), is(reversedList));
    }

    @Test
    public void itShouldReverseLinkedListOfTreeNodes() {
        ListNode<Integer> list =
                new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));
        ListNode<Integer> reversedList =
                new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)));

        assertThat(listReverser.reverse(list), is(reversedList));
    }

    @Test
    public void itShouldReverseLinkedListOfOneNodeRecursively() {
        ListNode<Integer> list = new ListNode<>(1);
        ListNode<Integer> reversedList = new ListNode<>(1);

        assertThat(listReverser.reverseRecursively(list), is(reversedList));
    }

    @Test
    public void itShouldReverseLinkedListOfTwoNodesRecursively() {
        ListNode<Integer> list = new ListNode<>(1, new ListNode<>(2));
        ListNode<Integer> reversedList = new ListNode<>(2, new ListNode<>(1));

        assertThat(listReverser.reverseRecursively(list), is(reversedList));
    }

    @Test
    public void itShouldReverseLinkedListOfTreeNodesRecursively() {
        ListNode<Integer> list =
                new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));
        ListNode<Integer> reversedList =
                new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)));

        assertThat(listReverser.reverseRecursively(list), is(reversedList));
    }

}
