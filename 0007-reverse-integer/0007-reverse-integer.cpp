class Solution {
public:
    int reverse(int x) {
        int sign = 1;
        if (x >= INT_MAX || x <= INT_MIN) return 0;
        if (x < 0) {
            x = -x;
            sign = 0;
        }
        long long int y = 0;
        while(x > 0) {
            y = y*10 + x%10;
            x /= 10;
        }
        if (y >= INT_MAX || y <= INT_MIN) return 0;
        if (sign) return y;
        else return -y;
    }
};