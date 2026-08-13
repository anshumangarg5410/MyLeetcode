class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;

        int len1 = s1.length();
        int len2 = s2.length();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < len1; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        while(right < len2) {

            char ch = s2.charAt(right);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            if(right - left + 1 > len1) {
                char remove = s2.charAt(left);

                map2.put(remove, map2.get(remove) - 1);

                if(map2.get(remove) == 0) {
                    map2.remove(remove);
                }

                left++;
            }

            if(map1.equals(map2)) {
                return true;
            }

            right++;
        }

        return false;
    }
}