class Solution {

    class SmartGene {
        String gene;
        int mutations;
        List<Integer> visitedIndex = new ArrayList<>();

        SmartGene(String gene, List<Integer> visitedIndex, int mutations) {
            this.gene = gene;
            this.mutations = mutations;
            this.visitedIndex = visitedIndex;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        // HashMap<Character, Integer> currentMap = new HashMap<>();
        int length = startGene.length();
        char[] charFreqOrig = new char[length];
        Queue<SmartGene> q = new LinkedList<>();
        q.offer(new SmartGene(startGene, new ArrayList<>(), 0));
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            SmartGene current = q.poll();
            String crntStr = current.gene;
            int crntMutations = current.mutations;

            // System.out.println(crntStr + " " + crntMutations);

            if (crntStr.equals(endGene)) {
                // System.out.println("yesss");
                ans = Math.min(crntMutations, ans);
            }

            for(int i = 0; i < length; i++) {
                charFreqOrig[i] = crntStr.charAt(i);
            }

            for(int i = 0; i < bank.length; i++) {
                List<Integer> visitedIndex = current.visitedIndex;
                // System.out.print(i + ": " + visitedIndex + ", ");
                if (visitedIndex.contains(i)) continue;
                String bankStr = bank[i];
                // HashMap<Character,Integer> bankMap = new HashMap<>();
                char[] charFreqBank = new char[length];

                // for(char ch : bankStr.toCharArray()) {
                //     bankMap.put(ch, bankMap.getOrDefault(ch, 0) + 1);
                // }

                for(int j = 0; j < length; j++) {
                    charFreqBank[j] = bankStr.charAt(j);
                }

                if (charFreqOrig.equals(charFreqBank)) {
                    // System.out.println("both map are equal");
                    continue;
                }

                int notEqual = 0;

                // for(Map.Entry<Character, Integer> mapp : bankMap.entrySet()) {
                //     char ch = mapp.getKey();
                //     int freq = mapp.getValue();

                //     if (currentMap.get(ch) != freq) {
                //         notEqual += Math.abs(currentMap.get(ch) - freq);
                //     }
                // }

                for(int j = 0; j < length; j++) {
                    if (charFreqBank[j] != charFreqOrig[j]) notEqual++;
                }

                if (notEqual != 1) {
                    // System.out.println("NOT EQUAL" + notEqual);
                    continue;
                }
                
                visitedIndex.add(i);
                q.offer(new SmartGene(bankStr, visitedIndex, crntMutations + 1));
            }

            // System.out.println();
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}