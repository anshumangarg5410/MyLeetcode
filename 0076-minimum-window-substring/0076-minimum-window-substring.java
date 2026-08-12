class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sb_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1); 
        }

        int left = 0, right = 0;
        // StringBuilder sb = new StringBuilder();
        // StringBuilder ans = sb;
        int size = 0;
        char ch_left = s.charAt(0);

        int start = 0, end = 0;

        int formed = 0;

        int ansStart = 0;
        int ansEnd = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch_right = s.charAt(right);
            // char ch_left = s.charAt(left);
            ch_left = s.charAt(start);

            if (t_map.containsKey(ch_right)) {
                sb_map.put(ch_right, sb_map.getOrDefault(ch_right, 0) + 1);

                if (sb_map.get(ch_right).equals(t_map.get(ch_right))) {
                    formed++;
                }

                // System.out.print("NORMALLY ADDED " + ch_right);
            }
            else {
                // System.out.print("NORMALLY ADDED " + ch_right);
            }

            right++;
            end = right;

            while (formed == t_map.size()) {

                if (end - start < minLength) {
                    minLength = end - start;
                    ansStart = start;
                    ansEnd = end;
                }

                ch_left = s.charAt(start);

                if (t_map.containsKey(ch_left)) {

                    if (sb_map.get(ch_left).equals(t_map.get(ch_left))) {
                        formed--;
                    }

                    if (sb_map.get(ch_left) == 1) {
                        sb_map.remove(ch_left);
                    }
                    else {
                        sb_map.put(ch_left, sb_map.get(ch_left) - 1);
                    }
                }

                start++;

                // System.out.println(" = " + s.substring(start, end));
            }
        }

        return s.substring(ansStart, ansEnd);
    }
}