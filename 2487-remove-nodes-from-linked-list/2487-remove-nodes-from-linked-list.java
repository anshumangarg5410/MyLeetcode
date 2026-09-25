/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode ans = new ListNode(0);

        ListNode temp = head;
        Stack<ListNode> st = new Stack<>();

        while (temp != null) {
            int vall = temp.val;

            while (!st.isEmpty() && st.peek().val < vall) {
                st.pop();
            }

            st.push(temp);

            temp = temp.next;
        }

        temp = ans;

        for(ListNode i : st) {
            System.out.println(i.val);
            temp.next = new ListNode(i.val);
            temp = temp.next;
        }

        return ans.next;

    }

}