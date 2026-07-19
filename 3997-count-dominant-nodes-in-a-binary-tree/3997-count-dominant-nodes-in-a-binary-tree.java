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

    int ans = 0;

    public int podfs(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int leftMax = podfs(root.left);
        int rightMax = podfs(root.right);

        if (root.val >= leftMax && root.val >= rightMax) ans++;

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public int countDominantNodes(TreeNode root) {
        podfs(root);
        return ans;
    }
}