package com.ffbit.algorithms.list;

import java.util.Objects;

/**
 * Reverse a Singly Linked List.
 */
public class ReverseSinglyLinkedList {

    public static class ListNode<E> {
        private E value;
        private ListNode<E> next;

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(E value) {
            this(value, null);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ListNode)) {
                return false;
            }

            ListNode<E> that = (ListNode<E>) o;

            return Objects.equals(value, that.value)
                    && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            ListNode<E> current = this;

            StringBuilder output = new StringBuilder();
            while (current != null) {
                output.append(current.value);
                current = current.next;

                if (current != null) {
                    output.append(" -> ");
                }
            }

            return output.toString();
        }
    }

    public <E> ListNode<E> reverse(ListNode<E> list) {
        ListNode<E> reversedList = null;
        ListNode<E> head = list;

        while (head != null) {
            ListNode<E> tail = head.next;
            head.next = reversedList;
            reversedList = head;
            head = tail;
        }

        return reversedList;
    }

}
