class Solution {
    public int[] divisibilityArray(String word, int m) {
        long rem = (word.charAt(0) - '0') % m;

        int[] ans = new int[word.length()];

        ans[0] = rem == 0 ? 1 : 0;

        for(int i = 1; i < word.length(); i++) {
            rem = ((rem*10) + (word.charAt(i)) - '0') % m;
            ans[i] = rem == 0 ? 1 : 0;
        }

        return ans;
        
    }
}