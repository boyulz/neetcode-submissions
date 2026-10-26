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
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedSecondHalf = reverse(slow.next);
        slow.next = null;
        while (reversedSecondHalf != null) {
            cur.next = head;
            head = head.next;
            cur.next.next = reversedSecondHalf;
            reversedSecondHalf = reversedSecondHalf.next;
            cur = cur.next.next;
        }
        cur.next = head;
        head = dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
