class Solution {

    long MOD = 1000000007;

    public int pow(int a, int exp) {
        if (exp == 0) return 1;
        a %= MOD;

        int half = pow(a, exp / 2);
        long ans = ((long) half * half) % MOD;

        if (exp % 2 == 1) {
            ans = (ans * a) % MOD;
        }

        return (int) ans;
    }

    public int monkeyMove(int n) {
        int total = pow(2, n);

        return (int)((total - 2 + MOD) % MOD);
    }
}