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

    HashMap<Integer, Integer> sortedMap;

    public TreeNode builder(int[] preOrder, int sortStart, int sortEnd, int index) {
        if (sortStart > sortEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index]);

        int sortedInd = sortedMap.get(root.val);

        int leftSize = sortedInd - sortStart;

        root.left = builder(preOrder, sortStart, sortedInd - 1, index + 1);
        root.right = builder(preOrder, sortedInd + 1, sortEnd, index + leftSize + 1);

        return root;
    }

    public void print(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        sortedMap = new HashMap<>();
        int[] sorted = preorder.clone();
        Arrays.sort(sorted);

        for(int i = 0; i < sorted.length; i++) {
            sortedMap.put(sorted[i], i);
        }

        return builder(preorder, 0, sorted.length - 1, 0);
    }
}