class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int cnt = 0, ele = 0;

        for (int num : nums) {
            if (cnt == 0) {
                ele = num;
            }
            if (num == ele) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        return ele;
    }
};