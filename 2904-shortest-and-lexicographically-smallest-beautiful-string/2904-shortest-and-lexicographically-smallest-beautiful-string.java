class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = new String(s);
        int n = s.length();
        List<String> lst = new ArrayList<>();
        
        int left = 0, right = 0, count = 0;

        while (right < n) {
            int current = s.charAt(right) - '0';

            if (current == 1) {
                count++;
            } 

            while (count >= k) {
                lst.add(s.substring(left, right + 1));

                if (s.charAt(left) - '0' == 1) count--;
                left++;
            }

            right++;

        }

        // for(String i : lst) {
        //     System.out.println(i);
        // }

        Collections.sort(lst, (a, b) -> a.length() - b.length());

        if (lst.size() == 0) return "";

        int minLen = lst.get(0).length();

        List<String> ansLst = new ArrayList<>();

        for(String i : lst) {
            if (i.length() == minLen) {
                ansLst.add(i);
            }
        }

        Collections.sort(ansLst);

        // for(String i : ansLst) {
        //     System.out.println(i);
        // }



        return ansLst.get(0);
    }
}