class Solution {
public:
    bool isPowerOfThree(int n) {
        int m = n;
        if (m == 1) return true;
        if (m <= 0) return false;
        while(1){
            if (m %3 != 0) return false;
            m = m/3;
            if (m == 1) return true;
        }
    }
};