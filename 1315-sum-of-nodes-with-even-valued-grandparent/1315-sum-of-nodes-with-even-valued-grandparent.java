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

    static int sum;

    public void addNdTrav(TreeNode root) {
        if (root == null) return;

        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;
    }

    public void bt(TreeNode root) {
        if (root == null) return;

        if (root.val %2 == 0) {
            addNdTrav(root.left);
            addNdTrav(root.right);

            bt(root.left);
            bt(root.right);
        }
        else {
            bt(root.left);
            bt(root.right);
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;

        bt(root);
        return sum;
    }
}