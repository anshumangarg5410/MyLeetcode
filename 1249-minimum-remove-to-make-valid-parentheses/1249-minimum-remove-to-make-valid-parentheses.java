class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        StringBuilder ans = new StringBuilder();

        boolean[] crct = new boolean[s.length()];

        for(int i = 0; i <s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                crct[i] = true;
            } 
            else {
                if (ch == '(') {
                    st.push(ch);
                    ind.push(i);
                }
                else if (ch == ')') {
                    if (st.isEmpty()) {
                        crct[i] = false;
                    }
                    else {
                        st.pop();
                        crct[i] = true;
                        crct[ind.pop()] = true;
                    }
                }
            }

        }

        if (!st.isEmpty()) {
            while (!st.isEmpty()) {
                crct[ind.pop()] = false;
                st.pop();
            }
        }

        for(int i = 0; i < crct.length; i++) {
            if (crct[i] == true) {
                ans.append(s.charAt(i));
            }
        }

        for(boolean i : crct) {
            System.out.print(i + ", ");
        }

        return ans.toString();
    }
}