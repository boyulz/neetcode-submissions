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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        int rootVal = preorder[0];
        // TreeNode node = new TreeNode(rootVal);
        int inorderIdx = 0;
        while (true) {
            if (inorder[inorderIdx] == rootVal) {
                break;
            }
            inorderIdx ++;
        }
        TreeNode l = buildTree(Arrays.copyOfRange(preorder, 1, inorderIdx+1), Arrays.copyOfRange(inorder, 0, inorderIdx));
        TreeNode r = buildTree(Arrays.copyOfRange(preorder, 1 + inorderIdx, n), Arrays.copyOfRange(inorder, inorderIdx + 1, n));
        return new TreeNode(rootVal, l, r);
    }
}
