class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charCount = new int[26];
        int n = s.length();
        System.out.println("--- " + n + " ---");

        for(int i = 0; i < n; i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        // for(int i = 0; i < 26; i++){
        //     System.out.println( (char)('a' + i) + " at" + charCount[i]);
        // }

        List<Integer> ans = new ArrayList<>();
        int targetIndex = 0;
        HashSet<Character> chs = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (!chs.contains(ch)) {
                targetIndex += charCount[ch - 'a'];
                chs.add(ch);
            }

            if ( (targetIndex - 1) == i) {
                // System.out.println("YES at " + i + " and ch : " + ch);
                // if (ans.size() > 0) ans.add(targetIndex - ans.get(ans.size() - 1));
                // else ans.add(targetIndex);

                ans.add(targetIndex);
                chs.clear();
            }
        }

        int size = ans.size() - 1;

        for(int i = size; i > 0; i--) {
            ans.set(i, ans.get(i) - ans.get(i-1));
        }

        return ans;
    }
}