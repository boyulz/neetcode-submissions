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
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return ans;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = findDepth(root.left);
        int r = findDepth(root.right);
        ans = Math.max(ans, l+r);
        return Math.max(l, r) + 1;
    }
}
