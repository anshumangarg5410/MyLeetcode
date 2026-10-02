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
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    int[] prefSum;

    public void traverseAdd(TreeNode root) {
        if (root == null) return;

        list.add(root.val);

        traverseAdd(root.left);
        traverseAdd(root.right);
    }

    public void changeTree(TreeNode root) {
        if (root == null) return;

        root.val = prefSum[map.get(root.val)];

        changeTree(root.left);
        changeTree(root.right);
    }


    public TreeNode bstToGst(TreeNode root) {
        list = new ArrayList<>();
        traverseAdd(root);
        Collections.sort(list);

        int n = list.size();

        prefSum = new int[n];
        int sum = 0;
        for(int i = n - 1; i >= 0; i--) {
            sum += list.get(i);
            prefSum[i] = sum;
        }

        map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(list.get(i), i);
        }

        changeTree(root);

        return root;

    }
}