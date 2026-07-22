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

    int no;
    int ans;

    public void helper(TreeNode root, int k) {
        if (root == null) return;

        helper(root.left, k);
        no--;
        if (no == 0) ans = root.val;
        // System.out.println(no + " and the val is " + root.val);
        helper(root.right, k);
    

    }

    public int kthSmallest(TreeNode root, int k) {
        no = k;
        helper(root, k);

        return ans;
    }
}