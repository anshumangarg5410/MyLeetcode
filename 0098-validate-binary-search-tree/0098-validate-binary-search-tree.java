class Solution {

    public boolean helper(TreeNode root, long maxVal, long minVal) {
        if (root == null) {
            return true;
        }

        // System.out.println("CURRENTLY AT " + root.val + " with max and min as: " + maxVal + " and " + minVal);

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        if (root.left != null) {
            if (!helper(root.left, root.val, minVal)) {
                return false;
            }
        }

        if (root.right != null) {
            if (!helper(root.right, maxVal, root.val)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}