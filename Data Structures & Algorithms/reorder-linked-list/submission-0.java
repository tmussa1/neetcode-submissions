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
        

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverseLinkedList(slow);

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode original = head, curr = dummyNode;

        boolean isOdd = false;

        while(original != null && reversed != null){

            if(isOdd){
                curr.next = reversed;
                reversed = reversed.next;
            } else {
                curr.next = original;
                original = original.next;
            }

            isOdd = !isOdd;

            curr = curr.next;
        }

        head = dummyNode.next;
    }

    private ListNode reverseLinkedList(ListNode head){

        ListNode prev = null, curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
