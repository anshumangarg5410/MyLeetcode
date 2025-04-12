class Solution {
public:
    int mySqrt(int x) {
        int start = 0; int end = x;
        while (start <= end){
            long long int mid = start + (end - start)/2;
            if ((mid * mid) > x) end = --mid;
            else if ((mid * mid) < x) start = ++mid;
            else if ((mid * mid) == x) return mid;
        }
        return start-1;
    }
};