class Solution {
    public String lexGreaterPermutation(String s, String target) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String ans = "";

        for(int idx = target.length() - 1; idx >= 0; idx--) {
            HashMap<Character, Integer> temp = new HashMap<>(map);
            StringBuilder curr = new StringBuilder();
            boolean ok = true;

            for(int i = 0; i < idx; i++) {
                char ch = target.charAt(i);

                if(!temp.containsKey(ch)) {
                    ok = false;
                    break;
                }

                curr.append(ch);

                if(temp.get(ch) == 1) temp.remove(ch);
                else temp.put(ch, temp.get(ch) - 1);
            }

            if(!ok) continue;

            char ch = target.charAt(idx);

            for(char c = (char)(ch + 1); c <= 'z'; c++) {
                if(temp.containsKey(c)) {
                    curr.append(c);

                    if(temp.get(c) == 1) temp.remove(c);
                    else temp.put(c, temp.get(c) - 1);

                    for(char x = 'a'; x <= 'z'; x++) {
                        while(temp.containsKey(x)) {
                            curr.append(x);

                            if(temp.get(x) == 1) temp.remove(x);
                            else temp.put(x, temp.get(x) - 1);
                        }
                    }

                    String possible = curr.toString();

                    // System.out.println("idx: " + idx);
                    // System.out.println("possible: " + possible);

                    if(possible.compareTo(target) > 0) {
                        if(ans.equals("") || possible.compareTo(ans) < 0) {
                            ans = possible;
                            // System.out.println("ans updated: " + ans);
                        }
                    }

                    break;
                }
            }
        }

        return ans;
    }
}