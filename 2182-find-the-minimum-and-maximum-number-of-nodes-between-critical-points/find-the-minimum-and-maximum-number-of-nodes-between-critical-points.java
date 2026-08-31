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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int p = -1, q = 1, r = -1, mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        ListNode curr = head.next, prev = head;
        
        while (curr != null && curr.next != null) {
            q++;
            if ((curr.val > prev.val && curr.val > curr.next.val) || 
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                if (p != -1) {
                    mini = Math.min(mini, q - p);
                    maxi = Math.max(maxi, q - r);
                } else {
                    r = q;
                }
                 p = q;
            }
            prev = curr;
            curr = curr.next;
        }
        
        if (mini == Integer.MAX_VALUE || maxi == Integer.MIN_VALUE) {
            return new int[]{-1, -1};
        } else {
            return new int[]{mini, maxi};
        }
    }
}
