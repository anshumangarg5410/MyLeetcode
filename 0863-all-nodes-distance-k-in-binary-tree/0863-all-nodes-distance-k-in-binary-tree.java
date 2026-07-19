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

    List<Integer> ans = new ArrayList<>();

    public void goDown(TreeNode root, int k) {
        if (root == null || k < 0) return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        goDown(root.left, k - 1);
        goDown(root.right, k - 1);
    }

    public int goDownUp(TreeNode root, TreeNode target, int k) {
        if (root == null)return -1;

        if (root == target) {
            goDown(root, k);
            return 0;
        }

        int left = goDownUp(root.left, target, k);

        if (left != -1) {
            if (left + 1 == k) ans.add(root.val);
            else goDown(root.right, k - left - 2);

            return left + 1;
        }

        int right = goDownUp(root.right, target, k);

        if (right != -1) {
            if (right + 1 == k) ans.add(root.val);
            else goDown(root.left, k - right - 2);
            
            return right + 1;
        }
        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        goDownUp(root, target, k);

        return ans;
    }
}