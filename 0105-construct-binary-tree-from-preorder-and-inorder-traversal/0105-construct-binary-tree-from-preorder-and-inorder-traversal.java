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

    HashMap<Integer, Integer> map;
    
    public TreeNode build(int[] preOrder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);

        int ind = map.get(node.val);

        int left = ind - inStart;

        node.left = build(preOrder, preStart + 1, inStart, ind - 1);
        node.right = build(preOrder, preStart + left + 1, ind + 1, inEnd);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, 0, preorder.length - 1);




    }
}