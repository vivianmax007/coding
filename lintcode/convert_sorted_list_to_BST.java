/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * 
 * O(n). 
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        if (head == null) {
            return null; 
        }
        
        ListNode prev = null; 
        ListNode slow = head; 
        ListNode fast = head.next; 
        
        while (fast != null) {
            fast = fast.next; 
            
            if (fast != null) {
                prev = slow; 
                slow = slow.next; 
                fast = fast.next; 
            }
        }
        
        if (prev != null) {
            prev.next = null; 
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        if (prev == null) {
            root.left = null; 
        } else {
            root.left = sortedListToBST(head);
        }
        
        root.right = sortedListToBST(slow.next);
        
        return root; 
    }
}

