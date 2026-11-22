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
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        search(root, vals);
        return vals.get(k-1);
    }

    private void search(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        search(node.left, vals);
        vals.add(node.val);
        search(node.right, vals);
    }
}
