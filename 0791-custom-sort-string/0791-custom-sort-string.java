class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            set.add(ch);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);

            if(map.containsKey(ch)) {
                set.remove(ch);
                int fr = map.get(ch);

                for(int j = 0; j < fr; j++) {
                    sb.append(ch);
                }
            }
        }

        for(char ch : set) {
            int fr = map.get(ch);

            for(int j = 0; j < fr; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}