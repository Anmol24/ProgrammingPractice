/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class AddTwoNumbersLeetcode {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, curr = null;
        int carry = 0;
        int val = 0;
        while (l1 != null || l2 != null) {
            val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = val / 10;
            if (head == null) {
                head = new ListNode(val % 10);
                curr = head;
            } else {
                curr.next = new ListNode(val % 10);
                curr = curr.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);
        while(result!=null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
