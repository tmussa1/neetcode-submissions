/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        

        ListNode currA = headA, currB = headB;

        while(currA != currB){
            
            if(currA == currB){
                return currA;
            }

            currA = currA != null ? currA.next : headB;
            currB = currB != null ? currB.next : headA;
        }


        return currA;
    }
}