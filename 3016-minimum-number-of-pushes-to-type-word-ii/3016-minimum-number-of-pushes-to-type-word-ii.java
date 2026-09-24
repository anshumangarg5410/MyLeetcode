class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int n = word.length();

        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            set.add(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Character> sortedByFreq = new ArrayList<>();

        for(char i : set) {
            sortedByFreq.add(i);
        }

        Collections.sort(sortedByFreq, (a, b) -> map.get(b) - map.get(a));

        // for(char i : sortedByFreq) {
        //     System.out.print(i + " ");
        // }

        // System.out.println();

        int len = set.size();
        // 12 + 16
        int[] arr = new int[8]; //starts with 1;
        int[] convention = {3,3,3,3,3,4,3,4};

        int iterator = 0;
        int ans = 0;
        for(char i : sortedByFreq) {
            // System.out.print(i + " ");
            int index = iterator % 8;

            if (arr[index] < convention[index]) {
                arr[index]++;
                // System.out.println("Mapped at once");
            }
            else {
                // System.out.println("Key was full and so had gopne further !!");
                while (arr[iterator % 8] >= convention[iterator % 8]) {
                    iterator++;
                }

                arr[iterator % 8]++;
            }

            index = iterator % 8;

            ans += arr[index] * map.get(i);
            iterator++;
        }

        // System.out.println();
        // for(int i : arr) System.out.print(i + " ");

        return ans;

    }
}