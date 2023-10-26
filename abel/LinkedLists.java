//package abel;

import java.util.LinkedList;

public class LinkedLists {
 

//* Linked List/double linked list
    Node head;

    private static class Node {
        int item;
        Node next;

        Node(int val) {
            item = val;
        }
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        list = insertInto(list, 5);
        list = insertInto(list, 2);
        list = insertInto(list, 1);
        list = insertInto(list, 7);

        System.out.println("Original Linked List:");
        printList(list);

        int valueToDelete = 5;
        deleteNode(list, valueToDelete);

        System.out.println("\nLinked List after deleting nodes with value " + valueToDelete + ":");
        printList(list);
    }

    public static LinkedLists insertInto(LinkedLists list, int data) {
        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void deleteNode(LinkedLists list, int value) {
        Node current = list.head;
        Node prev = null;

        while (current != null) {
            if (current.item == value) {
                if (prev == null) {
                    list.head = current.next;
                } else {
                    prev.next = current.next;
                }
                current = current.next; // Move to the next node after deletion
            } else {
                prev = current;
                current = current.next;
            }
        }
    }
//The output is :  
//Original Linked List:
//5 2 1 7

//Linked List after deleting nodes with value 5:
//2 1 7
    public static void printList(LinkedLists list) {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.item + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }
}
