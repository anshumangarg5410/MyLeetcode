/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current == null) {
                sb.append("N ");
            } else {
                sb.append(current.val).append(" ");
                q.offer(current.left);
                q.offer(current.right);
            }
        }

        while (sb.length() >= 2 && sb.substring(sb.length() - 2).equals("N ")) {
            sb.delete(sb.length() - 2, sb.length());
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < values.length) {
            TreeNode current = q.poll();

            if (!values[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(current.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


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