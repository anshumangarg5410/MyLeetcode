class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1000000007L;
        int size = nums.size();

        int[] arr = new int[32];

        for(int j = 0; j < size; j++) {
            for(int i = 0; i < 32; i++) {
                arr[i] += ((nums.get(j) >> i) & 1) == 1 ? 1 : 0;
                // System.out.print(arr[i] + " ");
            }
        }

        int[] ans = new int[k];

        for(int j = 0; j < 32; j++) {
            for(int i = 0; i < k; i++) {
                if (arr[j] > 0) {
                    ans[i] |= (1 << j);
                    arr[j]--;
                }
            }
        }

        for(int i : ans) System.out.println(i);

        int result = 0;

        for(int i : ans) {
            result = (int)((result + (long) i * i) % MOD);
        }

        return (int)((long)result % MOD);
    }
}