import java.util.*;
import java.io.*;
public class Main {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;

        while(curr!=null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode nhead = head.next;
        ListNode c1 = head, c2 = nhead;

        while(c2!=null && c2.next!=null){
            ListNode f1 = c2.next;
            c1.next = f1;
            c2.next = f1.next;

            c1 = c1.next;
            c2 = c2.next;
        }

        c1.next = reverse(nhead);
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
