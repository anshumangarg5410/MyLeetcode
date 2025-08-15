class Solution {
public:
    bool validornot(int x, vector<int>& piles, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + x - 1) / x;
        }
        return time <= h;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int start = 1;
        int end = *max_element(piles.begin(), piles.end());

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (validornot(mid, piles, h)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
};