class Solution {

    public int singleCheck(char c, String s, int k) {
        int left = 0, right = 0;
        int t = k;

        int maxLength = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            
            if (ch == c) {
                right++;
            }
            else {
                if (t > 0) {
                    t--;
                    right++;
                }
                else {
                    if (s.charAt(left) != c) {
                        t++;
                    }
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public int characterReplacement(String s, int k) {
        int ans = 0;

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            ans = Math.max(singleCheck(ch, s, k), ans);
        }

        return ans;
    }
}