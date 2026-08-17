class Solution {

    class SmartGene {
        String gene;
        int mutations;

        SmartGene(String gene, int mutations) {
            this.gene = gene;
            this.mutations = mutations;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        Queue<SmartGene> q = new LinkedList<>();
        q.offer(new SmartGene(beginWord, 1));

        boolean[] visited = new boolean[wordList.size()];

        while (!q.isEmpty()) {
            SmartGene current = q.poll();

            String currentWord = current.gene;
            int currentMutations = current.mutations;

            if (currentWord.equals(endWord)) {
                return currentMutations;
            }

            for (int i = 0; i < wordList.size(); i++) {

                if (visited[i]) continue;
                String bankWord = wordList.get(i);
                int notEqual = 0;

                for (int j = 0; j < length; j++) {
                    if (currentWord.charAt(j) != bankWord.charAt(j)) {
                        notEqual++;
                        if (notEqual > 1) break;
                    }
                }

                if (notEqual == 1) {
                    visited[i] = true;
                    q.offer(new SmartGene(bankWord, currentMutations + 1));
                }
            }
        }

        return 0;
    }
}