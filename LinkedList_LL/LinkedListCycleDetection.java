package LinkedList_LL;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycleDetection {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;     

            if (slow == fast) {
                return true;           
            }
        }
        return false;                  
    }

    public static ListNode detectStartNodeOfCycle(ListNode head){

        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;
                
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static ListNode createLinkedList(int n, Scanner sc) {
        if (n <= 0) return null;

        System.out.print("Enter node 1: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter node " + i + ": ");
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void createCycle(ListNode head, int pos) {
        if (pos == -1) return; 

        ListNode tail = head;
        ListNode cycleNode = null;
        int index = 0;

        while (true) {
            if (index == pos) cycleNode = tail;
            if (tail.next == null){
                break;
            }
            tail = tail.next;
            index++;
        }

        if (cycleNode != null) {
            tail.next = cycleNode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = createLinkedList(n, sc);

        System.out.print("Enter position to create cycle (-1 for no cycle): ");
        int pos = sc.nextInt();
        createCycle(head, pos);

        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }

        ListNode cycleStart = detectStartNodeOfCycle(head);
        if (cycleStart != null){
            System.err.println("Cycle is detected at the node: " + cycleStart.val);
        }

        sc.close();
    }
}
