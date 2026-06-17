package com.interview.common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static int[] toArray(ListNode head) {
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }

        int[] values = new int[size];
        int index = 0;
        for (ListNode node = head; node != null; node = node.next) {
            values[index++] = node.val;
        }
        return values;
    }
}
