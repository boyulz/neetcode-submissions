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
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 0);
        return ans;
    }

    private void traverse(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (height >= ans.size()) {
            ans.add(node.val);
        }
        traverse(node.right, height + 1);
        traverse(node.left, height + 1);
    }
}
