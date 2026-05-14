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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;

        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            curr.next = new ListNode(sum % 10);
            carry = ((int) Math.floor(sum * 1.0 / 10.0));
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }

        while(l1 != null){
            int sum = carry + l1.val;
            curr.next = new ListNode(sum % 10);
            carry = ((int) Math.floor(sum * 1.0 / 10.0));
            l1 = l1.next;
            curr = curr.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            curr.next = new ListNode(sum % 10);
            carry = ((int) Math.floor(sum * 1.0 / 10.0));
            l2 = l2.next;
            curr = curr.next;
        }

        if(carry == 1){
            curr.next = new ListNode(1);
        }


        return dummy.next;
    }
    // 126 + 456 = 582
    // 621 + 654 = 1275
}
