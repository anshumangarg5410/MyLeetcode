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

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int finalAns = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            long start = 0;
            long end = 0;
            long min = q.peek().index;

            for(int i = 0; i < size; i++) {

                Pair current = q.poll();

                long index = current.index - min;

                if(i == 0) start = index;
                if(i == size - 1) end = index;

                if(current.node.left != null) q.offer(new Pair(current.node.left, 2 * index + 1));

                if(current.node.right != null) q.offer(new Pair(current.node.right, 2 * index + 2));
            }

            finalAns = Math.max(finalAns, (int)(end - start + 1));
        }

        return finalAns;
    }
}