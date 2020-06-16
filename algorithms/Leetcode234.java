/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        
        int i = -1, j = values.size();
        while (++i < --j) {
            int x = values.get(i), y = values.get(j);
            if (x != y) return false;
        }
        
        return true;
    }
}
