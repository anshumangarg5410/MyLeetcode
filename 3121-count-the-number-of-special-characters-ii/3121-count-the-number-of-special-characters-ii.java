class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        HashMap<Character, Integer> upperCase = new HashMap<>();
        HashMap<Character, Integer> lowerCase = new HashMap<>();

        HashSet<Character> rejected = new HashSet<>();
        HashSet<Character> accepted = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            
            if (ch >= 97) { //lowercase
                if (rejected.contains(ch)) continue;

                char complement = (char)(ch - 32);
                lowerCase.put(ch, lowerCase.getOrDefault(ch, 0) + 1);

                if (upperCase.containsKey(complement)) {
                    rejected.add(ch);
                }

            }
            else { //uppercase
                char complement = (char)(ch + 32);
                if (rejected.contains(complement)) continue;

                upperCase.put(ch, upperCase.getOrDefault(ch, 0) + 1);

                if (lowerCase.containsKey(complement)) {
                    accepted.add(complement);
                }
                else {
                    rejected.add(complement);
                }

            }
        }

        int ans = 0;

        for(Character ch : accepted) {
            if (!rejected.contains(ch)) ans++;
        }

        return ans;
        
    }
}