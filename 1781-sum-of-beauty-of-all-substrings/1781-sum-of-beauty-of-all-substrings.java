class Solution {
    public int beautySum(String s) {
        int ans = 0;
    
        for(int i = 0; i < s.length(); i++) {
            int[] arr = new int[26];
            int max = 0;
            int min = Integer.MAX_VALUE;

            for(int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                arr[ch - 'a']++;

                for(int k = 0; k < 26; k++) {
                    // System.out.print(arr[k] + " ");
                    if (arr[k] == 0) continue;
                    max = Math.max(max, arr[k]);
                    min = Math.min(min, arr[k]);
                }

                ans += max - min > 0 ? max - min : 0;
                // System.out.print(" " + max + " " + min);
                // System.out.println();
                max = 0;
                min = Integer.MAX_VALUE;
            }

        }

        return ans;
    }
}