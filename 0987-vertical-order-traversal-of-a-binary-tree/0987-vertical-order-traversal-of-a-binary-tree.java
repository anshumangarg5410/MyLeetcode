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

class SmartTreeNode {
    TreeNode original;
    SmartTreeNode left;
    SmartTreeNode right;
    int row;
    int col;
    int val;

    SmartTreeNode(TreeNode original, int row, int col) {
        this.original = original;
        this.row = row;
        this.col = col;
        this.left = null;
        this.right = null;
        this.val = original.val;
    }
}

class Solution {

    int maxRow = 0;
    int maxCol = 0;

    int minRow = 0;
    int minCol = 0;

    public void trav(SmartTreeNode root) {
        if (root == null) return;

        maxRow = Math.max(maxRow, root.row);
        maxCol = Math.max(maxCol, root.col);
        minCol = Math.min(minCol, root.col);
        minRow = Math.min(minRow, root.row);
        
        // System.out.println(root.val + " with row: " + root.row + " and with col: " + root.col);
        
        trav(root.left);
        trav(root.right);
    }

    public SmartTreeNode copyTree(TreeNode root, int row, int col) {
        if (root == null) {
            return null;
        }

        SmartTreeNode smartRoot = new SmartTreeNode(root, row, col);

        smartRoot.left = copyTree(root.left, row + 1, col - 1);
        smartRoot.right = copyTree(root.right, row + 1, col + 1);

        return smartRoot;
    }

    class NodeInfo {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        SmartTreeNode smartRoot = copyTree(root, 0, 0);

        trav(smartRoot);

        int col = maxRow - minRow + 1;
        int row = maxCol - minCol + 1;

        List<List<NodeInfo>> temp = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            temp.add(new ArrayList<>());
        }

        Deque<SmartTreeNode> q = new ArrayDeque<>();
        int colCorrection = -(minCol);

        q.offer(smartRoot);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                SmartTreeNode ele = q.poll();

                temp.get(ele.col + colCorrection).add(new NodeInfo(ele.row, ele.val));

                if(ele.left != null) q.offer(ele.left);
                if(ele.right != null) q.offer(ele.right);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<NodeInfo> list : temp) {

            list.sort((a, b) -> {
                if (a.row != b.row) return a.row - b.row;
                return a.val - b.val;
            });

            List<Integer> curr = new ArrayList<>();

            for (NodeInfo node : list) curr.add(node.val);

            ans.add(curr);
        }

        return ans;
    }
}

