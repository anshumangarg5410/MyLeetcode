class Solution {

    private void bt(List<String> ans, String curr, int open, int close, int n) {
        if (open == n && close == n) {
            ans.add(curr);
            return;
        }

        if (open < n) {
            bt(ans, curr + "(", open + 1, close, n);
        }

        if (close < open) {
            bt(ans, curr + ")", open, close + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(ans, "", 0, 0, n);
        return ans;
    }


}




