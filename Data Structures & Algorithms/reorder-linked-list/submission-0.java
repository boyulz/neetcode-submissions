/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reverseSecondHalf = reverse(secondHalf);
        while (head != null && reverseSecondHalf != null) {
            ListNode nxt = head.next;
            head.next = reverseSecondHalf;
            reverseSecondHalf = reverseSecondHalf.next;
            head.next.next = nxt;
            head = head.next.next;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode nxt = node.next;
            node.next = pre;
            pre = node;
            node = nxt;
        }
        return pre;
    }
}
