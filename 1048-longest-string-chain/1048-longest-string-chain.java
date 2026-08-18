class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int n = words.length;
        int ans = 0;

        dp.put(words[0], 1);

        // for(int i = 0; i < n; i++) {
        //     int chain = 1;
        //     String current = words[i];

        //     System.out.println("Starting with: " + current);

        //     //now deleting every 1 character and finding if any permutation exists? 
        //     for(int j = 0; j < current.length(); j++) {
        //         StringBuilder deletedStr = new StringBuilder(current);
        //         deletedStr.deleteCharAt(j);

        //         //checking for the new string formed in the list
        //         if (map.containsKey(deletedStr.toString())) {
        //             current = deletedStr.toString();
        //             System.out.print("MOVING FORWARD: " + current + " -> ");
        //             chain++;
        //             j = -1;
        //         }
        //         else {
        //             continue;
        //         }

        //     }

        //     System.out.println();

        //     ans = Math.max(chain, ans);
        // }

        for(int i = 1; i < n; i++) {
            String current = words[i];
            int maxChain = 0;

            for(int j = 0; j < current.length(); j++) {
                StringBuilder deletedStr = new StringBuilder(current);
                deletedStr.deleteCharAt(j);

                if (dp.containsKey(deletedStr.toString())) {
                    maxChain = Math.max(maxChain, dp.get(deletedStr.toString()));
                }
            }

            dp.put(current, maxChain + 1);
        }

        for(Map.Entry<String, Integer> i : dp.entrySet()) {
            ans = Math.max(i.getValue(), ans);
        }

        return ans;
    }
}