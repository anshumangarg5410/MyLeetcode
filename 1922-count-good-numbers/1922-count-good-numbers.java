class Solution {

    long power(long x, long n) {

        if (n == 0) return 1;
        long half = power(x, n / 2);
        long ans = (half * half) % 1000000007;

        if (n % 2 == 1) ans = (ans * x) % 1000000007;

        return ans;
    }

    public int countGoodNumbers(long n) {
        if (n == 1) return 5;

        long primeNo, evenNo;
        if (n % 2 != 0) {
            primeNo = n/2;
            evenNo = n - primeNo;
        }
        else {
            primeNo = n/2;
            evenNo = n/2;
        }
        
        long primeM = power(4, primeNo); 
        long evenN = power(5, evenNo);

        // System.out.println(primeM);
        // System.out.println(evenN);

        int ans = (int)((primeM * evenN) % 1000000007);

        return ans;

    }
}