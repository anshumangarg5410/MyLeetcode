class Solution {
public:
    double myPow(double x, int n) {
        int long long num = n; double result = 1.0;
        if (x == 0) return 0; 
        if (x == 1 || n == 0) return 1;
        if (num < 0) {
            num = -num;
            x = 1/x;
        }
        while(num > 0){
            if (num %2 != 0){
                result *= x;
                
            }
            num /= 2;
            x *= x;
        }
        return result;

    }
};