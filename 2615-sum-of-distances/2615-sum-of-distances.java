class Solution {

    class Pair {
        long freq;
        long sumOfIndexes;

        Pair (long freq, long sumOfIndexes) {
            this.freq = freq;
            this.sumOfIndexes = sumOfIndexes;
        }
    }

    public long[] distance(int[] nums) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = nums.length;
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                Pair crnt = map.get(num);

                long freq = crnt.freq;
                long sum = crnt.sumOfIndexes;

                // System.out.println(num + " " + crnt.freq + " " + crnt.sumOfIndexes);

                if (freq >= 1) {
                    // System.out.println(" PROCEEDING ");
                    ans[i] = (i*freq) - sum;
                }
                else {
                    ans[i] = 0;
                }


                Pair current = map.get(num);
                current.freq++;
                current.sumOfIndexes += i;

                map.put(num, current);
            }
            else {
                map.put(num, new Pair(1, i));
                // System.out.println("ADDED AT " + i);
                ans[i] = 0;
            }
        }

        map.clear();

       for(int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            if (map.containsKey(num)) {
                Pair crnt = map.get(num);

                long freq = crnt.freq;
                long sum = crnt.sumOfIndexes;

                // System.out.println(num + " " + crnt.freq + " " + crnt.sumOfIndexes);

                if (freq >= 1) {
                    // System.out.println(" PROCEEDING ");
                    ans[i] += sum - (i*freq);
                }
                else {
                    ans[i] += 0;
                }


                Pair current = map.get(num);
                current.freq++;
                current.sumOfIndexes += i;

                map.put(num, current);
            }
            else {
                map.put(num, new Pair(1, i));
                // System.out.println("ADDED AT " + i);
                ans[i] += 0;
            }
        }

        return ans;


    }
}