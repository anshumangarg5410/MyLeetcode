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

    public TreeNode findRoot(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return root;

        TreeNode left = findRoot(root.left, key);
        TreeNode right = findRoot(root.right, key);

        return left != null ? left : right;
    }

    public TreeNode findParent(TreeNode root, TreeNode prev, TreeNode target) {
        if (root == null) return null;

        if (root == target) return prev;

        TreeNode left = findParent(root.left, root, target);
        TreeNode right = findParent(root.right, root, target);

        return left != null ? left : right;
    }

    public TreeNode maxLeft(TreeNode root) {
        if (root == null || root.left == null) return null;

        TreeNode curr = root.left;

        while (curr.right != null) {
            curr = curr.right;
        }

        return curr;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        TreeNode toBeRemoved = findRoot(root, key);

        if (toBeRemoved == null) return root;

        TreeNode parent = findParent(root, root, toBeRemoved);

        if (toBeRemoved.left == null && toBeRemoved.right == null) {

            if (toBeRemoved == root) return null;

            if (parent.left == toBeRemoved) parent.left = null;
            else parent.right = null;

            return root;
        }

        if (toBeRemoved.left != null && toBeRemoved.right == null) {

            if (toBeRemoved == root) return root.left;

            if (parent.left == toBeRemoved) parent.left = toBeRemoved.left;
            else parent.right = toBeRemoved.left;

            return root;
        }

        if (toBeRemoved.left == null && toBeRemoved.right != null) {

            if (toBeRemoved == root) return root.right;

            if (parent.left == toBeRemoved) parent.left = toBeRemoved.right;
            else parent.right = toBeRemoved.right;

            return root;
        }

        TreeNode predecessor = maxLeft(toBeRemoved);

        toBeRemoved.val = predecessor.val;

        TreeNode predecessorParent = findParent(root, root, predecessor);

        if (predecessorParent.left == predecessor) predecessorParent.left = predecessor.left;
        else predecessorParent.right = predecessor.left;

        return root;
    }
}