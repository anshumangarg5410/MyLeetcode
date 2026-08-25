class Solution {

    int MOD = 1337;

    public int power(int a, int p) {
        a %= MOD;
        int ans = 1;
        while (p-- > 0) {
            ans = (ans * a) % MOD;
        }
        return ans;
    }

    public int helper(int a, int[] b, int len) {
        if (len == 0)return 1;
        int lastDigit = b[len - 1];
        int remaining = helper(a, b, len - 1);

        return (power(remaining, 10) * power(a, lastDigit)) % MOD;
    }

    public int superPow(int a, int[] b) {
        return helper(a, b, b.length);
    }
}

