class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(sb);
                sb = new StringBuilder();
            }
            else if (ch == ')') {
                sb.reverse();

                StringBuilder prev = st.pop();
                prev.append(sb);

                sb = prev;
            }
            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}