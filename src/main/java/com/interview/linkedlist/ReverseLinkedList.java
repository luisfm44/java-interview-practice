package com.interview.linkedlist;

import com.interview.common.ListNode;

/**
 * LeetCode 206 - Reverse Linked List.
 * Invierte una lista enlazada y devuelve la nueva cabeza.
 *
 * PATRON (imperative): tres punteros prev / current / next.
 * PATRON (functional): recursion — invertir el resto y reconectar.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(java.util.Arrays.toString(
            ListNode.toArray(reverseLinkedList.reverseList(ListNode.of(1, 2, 3, 4, 5)))));
    }

    public ListNode reverseList(ListNode head) {
        return reverseListImperative(head);
    }

    public ListNode reverseListImperative(ListNode head) {
        ListNode previous = null; // lo que ya invertimos queda detras de previous
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // guardamos el siguiente antes de romper el enlace
            current.next = previous; // invertimos la flecha hacia atras
            previous = current; // previous avanza
            current = next; // current avanza
        }
        return previous; // al final previous es la nueva cabeza
    }

    public ListNode reverseListFunctional(ListNode head) {
        if (head == null || head.next == null) {
            return head; // caso base: lista vacia o un solo nodo
        }
        ListNode newHead = reverseListFunctional(head.next); // invertimos el resto de la lista
        head.next.next = head; // el siguiente nodo debe apuntar de vuelta a head
        head.next = null; // head deja de apuntar hacia adelante
        return newHead;
    }
}
