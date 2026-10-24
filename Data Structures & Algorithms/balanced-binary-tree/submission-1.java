/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int i = findDepth(root);
        return i != -1;
    }

    private int findDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = findDepth(node.left);
        int r = findDepth(node.right);
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        if (l == -1 || r == -1) {
            return -1;
        } else {
            return Math.max(l, r) + 1;
        }
    }
}
