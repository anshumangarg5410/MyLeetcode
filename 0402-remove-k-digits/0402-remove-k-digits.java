class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) - '0';

            while (!st.isEmpty() && k > 0 && st.peek() > curr) {
                st.pop();
                k--;
            }

            st.push(curr);
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}