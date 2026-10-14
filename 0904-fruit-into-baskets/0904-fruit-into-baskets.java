class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int end = fruits.length - 1;
        int fr = 0;
        for(int i = fruits.length - 1; i >= 0; i--) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            fr++;

            //more than 2 fruits added
            while (map.size() > 2 && end >= 0) {
                if (map.containsKey(fruits[end])) {
                    if (map.get(fruits[end]) > 1) {
                        map.put(fruits[end], map.get(fruits[end]) - 1);
                    }
                    else {
                        map.remove(fruits[end]);
                    }
                }
                fr--;
                end--;
            }
            ans = Math.max(fr, ans);

        }

        return ans;

    }
}

