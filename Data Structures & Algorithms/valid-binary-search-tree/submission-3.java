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
    private static final int inf = Integer.MAX_VALUE;
    private static final int negInf = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return f(root, negInf, inf);
        
    }

    private boolean f(TreeNode node, int l, int r) {
        if (node == null) {
            return true;
        }
        boolean left = f(node.left, l, node.val);
        boolean right = f(node.right, node.val, r);
        if (node.val > l && node.val < r && left && right) {
            return true;
        }
        return false;
    }
}
