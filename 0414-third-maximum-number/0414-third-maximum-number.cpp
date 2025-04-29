class Solution {
public:
    int thirdMax(vector<int>& nums) {
        // auto indexx = max_element(nums.begin(), nums.end());
        // int maxeleor = *indexx;
        // if (nums.size() < 3) return *indexx;
        // int element;
        // int count = 0;
        // while (true) {
        //     auto index = max_element(nums.begin(), nums.end());
        //     cout << "old" << element << endl;
        //     if (element != *index) count++;
        //     element = *index;
        //     cout << "new" << element << endl;
        //     nums.erase(index);
        //     // count++;
        //     if (count == 2) {
        //         if (element != *max_element(nums.begin(), nums.end())) return *max_element(nums.begin(), nums.end());
        //     }
        //     cout << nums.size()<<". " << count << endl;
        //     if (nums.size() == 0) return maxeleor;
        // }
        

        long first = LONG_MIN, second = LONG_MIN, third = LONG_MIN;
        for (int num : nums) {
            if (num == first || num == second || num == third) continue;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second) {
                third = second;
                second = num;
            }
            else if (num > third) {
                third = num;
            }
        }
        if (third == LONG_MIN) return first;
        else return third;
    }
};