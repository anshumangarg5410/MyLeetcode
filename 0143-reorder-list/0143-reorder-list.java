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
    public void reorderList(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        int iterator = 1;
        while (!stack.isEmpty()) {
            if (iterator %2 == 0) {
                temp.val = stack.peekFirst();
                stack.removeFirst();
            } else {
                temp.val = stack.peekLast();
                stack.removeLast();
            }
            temp = temp.next;
            iterator++;
        }


    }
}