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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        search(root, 0);
        return ans;
    }

    private void search(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (height == ans.size()) {
            ans.add(node.val);
        }
        search(node.right, height + 1);
        search(node.left, height + 1);
        return;
    }
}
