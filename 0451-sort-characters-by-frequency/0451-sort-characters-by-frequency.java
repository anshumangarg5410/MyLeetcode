class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        List<Map.Entry<Character, Integer>>  lst = new ArrayList<>(map.entrySet());



        Collections.sort(lst, (a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> e : lst) {
            System.out.println(e);
        }

        StringBuilder ans = new StringBuilder();

        for(Map.Entry<Character, Integer> e : lst) {
            for(int i = 0; i < e.getValue(); i++) {
                ans.append(e.getKey());
            }
        }

        return ans.toString();
    }
}