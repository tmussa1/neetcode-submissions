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
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head, prev = null;

        while(curr != null && curr.next != null){

            int val = curr.val;
            ListNode next = curr.next;
            int nextVal = next.val;
            int gcd = findGcd(val, nextVal);

            ListNode node = new ListNode(gcd);
            curr.next = node;
            node.next = next;
            curr = next;
        }

        return dummy.next;
    }
    private int findGcd(int a, int b){
        if(b == 0){
            return a;
        }

        return findGcd(b, a % b);
    }
}