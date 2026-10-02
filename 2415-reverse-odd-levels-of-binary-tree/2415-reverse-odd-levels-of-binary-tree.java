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
    public TreeNode reverseOddLevels(TreeNode root) {
        int height = 0;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            height++;
            ArrayList<TreeNode> list = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null) 
                {
                    q.offer(current.left);
                    list.add(current.left);
                }
                if (current.right != null) 
                {
                    q.offer(current.right);
                    list.add(current.right);
                }

            }

            int start = 0;
            int end = list.size() - 1;

            if (height %2 == 0) continue;
            while (start < end) {
                TreeNode first = list.get(start++);
                TreeNode last = list.get(end--);;

                int temp = first.val;
                first.val = last.val;
                last.val = temp;
            }
        }

        return root;
    }
}