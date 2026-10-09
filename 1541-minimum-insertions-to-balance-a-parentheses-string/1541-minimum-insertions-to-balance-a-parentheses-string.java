class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int len = s.length();
        int insertions = 0;

        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }
            else {
                if (i + 1 < len && s.charAt(i + 1) == ')') {
                    i++;
                }
                else {
                    insertions++;
                }

                if (open > 0) {
                    open--;
                }
                else {
                    insertions++;
                }
            }
        }

        insertions += open * 2;

        return insertions;
    }
}

