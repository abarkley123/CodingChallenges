/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode start = tmp;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            } else if (l2 == null) {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    tmp.next = new ListNode(l1.val);                    
                    tmp = tmp.next;
                    l1 = l1.next;
                } else {
                    tmp.next = new ListNode(l2.val);
                    tmp = tmp.next;
                    l2 = l2.next;
                }
            }
        }
        
        return start.next;
    }
}
