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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        int zigzag = 0;

        if(root == null)
            return list;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {

            int size = q.size();

            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {

                TreeNode ele = q.poll();

                temp.add(ele.val);

                if(ele.left != null)
                    q.offer(ele.left);

                if(ele.right != null)
                    q.offer(ele.right);
            }

            if (zigzag == 1) {
                zigzag = 0;
                Collections.reverse(temp);
            } 
            else {
                zigzag = 1;
            }

            list.add(temp);
        }

        return list;
    }
}