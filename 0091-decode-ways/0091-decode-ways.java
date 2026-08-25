class Solution {

    int[] dp;

    public int helper(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }

        if (dp[idx] != -1) return dp[idx];
        
        //taking double 
        int singleNo = (s.charAt(idx) - '0');

        if (singleNo == 0) {
            dp[idx] = 0;
            return 0;
        }

        int doubleNo = 0;
        if (idx < s.length() - 1) {
            doubleNo = (singleNo * 10) + (s.charAt(idx + 1) - '0');
        }

        if (idx < s.length() - 1 && doubleNo >= 10 && doubleNo <= 26) {
            // comb.add(doubleNo);
            dp[idx] = helper(s, idx + 2) + helper(s, idx + 1);

            //tkaing single
            // comb.remove(comb.size() - 1);
            // comb.add(singleNo);
            // helper(s, idx + 1, comb);
            // comb.remove(comb.size() - 1);
        }
        else {
            // comb.add(singleNo);
            dp[idx] = helper(s, idx + 1);
            // comb.remove(comb.size() - 1);
        }

        return dp[idx];
        
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        helper(s, 0);

        for(int i : dp) {
            System.out.println(i);
        }

        return dp[0];
    }
}