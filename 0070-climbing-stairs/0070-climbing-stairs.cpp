class Solution {
public:
    int climbStairs(int n) {
        if (n == 1) return 1;
        int a = 1, b = 2; int c; 
        for (int i = 3;i < n+1; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
};