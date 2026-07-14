class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int noTrues = 0;
        int left = 0, right = 0;
        int t = k;

        //checking maximum for the right
        int maxTrue = 0;
        while (right < answerKey.length()) {
            char ch = answerKey.charAt(right);
            
            if (ch == 'T') {
                right++;
            }
            else {
                if (t > 0) {
                    t--;
                    right++;
                }
                else {
                    if (answerKey.charAt(left) == 'F') {
                        t++;
                    }
                    left++;
                }
            }

            maxTrue = Math.max(maxTrue, right - left);
        }

        //checking maximum for the left
        left = 0; right = 0; t = k;
        int maxFalse = 0;
        while (right < answerKey.length()) {
            char ch = answerKey.charAt(right);
            
            if (ch == 'F') {
                right++;
            }
            else {
                if (t > 0) {
                    t--;
                    right++;
                }
                else {
                    if (answerKey.charAt(left) == 'T') {
                        t++;
                    }
                    left++;
                }
            }

            maxFalse = Math.max(maxFalse, right - left);
        }

        return Math.max(maxFalse, maxTrue);
    }
}