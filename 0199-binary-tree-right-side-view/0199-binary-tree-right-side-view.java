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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        st.offerLast(root);

        while (!st.isEmpty()) {
            int size = st.size();

            ans.add(st.peekLast().val);

            for(int i = 0; i < size; i++) {
                TreeNode top = st.pollFirst();

                if (top.left != null) st.offerLast(top.left);
                if (top.right != null) st.offerLast(top.right);
            }
        }

        return ans;
    }
}

