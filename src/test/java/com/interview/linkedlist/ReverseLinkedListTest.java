package com.interview.linkedlist;

import com.interview.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListTest {

  private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

  @Test
  void reversesNonEmptyList() {
    ListNode reversed = reverseLinkedList.reverseList(ListNode.of(1, 2, 3, 4, 5));
    assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, ListNode.toArray(reversed));
  }

  @Test
  void handlesSingleNode() {
    ListNode reversed = reverseLinkedList.reverseList(ListNode.of(1));
    assertArrayEquals(new int[] { 1 }, ListNode.toArray(reversed));
  }

  @Test
  void handlesEmptyList() {
    assertNull(reverseLinkedList.reverseList(null));
  }
}
