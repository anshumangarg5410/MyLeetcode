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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode ans = new ListNode(0);
        ListNode tempAns = ans;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int first = temp1 == null ? 0 : temp1.val;
            int second = temp2 == null ? 0 : temp2.val;

            int sum = first + second;

            if (carry == 1) {
                sum++;
                carry = 0;
            }

            if (sum >= 10) carry = 1;

            tempAns.next = new ListNode(sum % 10);
            tempAns = tempAns.next;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        if (carry == 1) {
            tempAns.next = new ListNode(1);

        }

        return ans.next;

    }
}