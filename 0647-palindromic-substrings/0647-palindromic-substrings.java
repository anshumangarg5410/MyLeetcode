class Solution {

    public int checker(String s, int left, int right) {
        int ans = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

            ans++;
        }

        return ans;
    }

    public int countSubstrings(String s) {
        if (s.length() < 1) return 0;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans += checker(s, i, i) + checker(s, i, i + 1);
        }

        return ans;
    }
}