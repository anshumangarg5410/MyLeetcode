class Solution {
public:
    int findClosest(int x, int y, int z) {
        if (abs(z - y) > abs(z-x)) return 1;
        else if (abs(z-y) == abs(z-x)) return 0;
        else return 2;
    }
};