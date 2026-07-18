/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<TreeNode> ancestorSingle = new Stack<>();

    public boolean ancestor(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            return true;
        }

        if (ancestor(root.left, target)) {
            ancestorSingle.push(root);
            return true;
        }

        if (ancestor(root.right, target)) {
            ancestorSingle.push(root);
            return true;
        }

        return false;
    }

    public boolean findRoot(TreeNode root, TreeNode target, TreeNode original) {
        if (root == null || root == original) {
            return false;
        }

        if (root == target) {
            return true;
        }

        if (findRoot(root.left, target, original)) {
            return true;
        }

        if (findRoot(root.right, target, original)) {
            return true;
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {    

        if (findRoot(p, q, null)) {
            return p;
        }
        else if (findRoot(q, p, null)) {
            return q;
        }

        ancestor(root, p);

        TreeNode ans = null;

        while (!ancestorSingle.isEmpty()) {
            TreeNode anses = ancestorSingle.pop();
            // System.out.println(anses.val);

            if (findRoot(anses, q, p)) {
                ans = anses;
            }
        }

        return ans;
    }
}