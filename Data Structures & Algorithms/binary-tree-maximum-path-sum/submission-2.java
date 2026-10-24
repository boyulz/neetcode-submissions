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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        search(root);
        return ans;
    }

    private int search(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = search(node.left);
        int r = search(node.right);
        ans = Math.max(l + r + node.val, ans);
        return Math.max(Math.max(l, r) + node.val, 0);
    }
}


//                 1
//             2       
//         3
//     4
// 5