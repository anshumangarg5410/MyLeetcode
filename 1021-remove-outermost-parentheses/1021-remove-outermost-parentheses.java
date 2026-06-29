class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' && st.isEmpty()) {
                System.out.println("YES AT I: " + i);
                st.push(ch);
            }
            else if (ch == '(' && !st.isEmpty()) {
                st.push(ch);
                ans.append(ch);
            }
            else if (ch == ')') {
                if (st.size() > 1) {
                    ans.append(ch);
                    st.pop();
                }
                else if (st.size() == 1) {
                    st.pop();
                }
            }
        }

        return ans.toString();
    }
}