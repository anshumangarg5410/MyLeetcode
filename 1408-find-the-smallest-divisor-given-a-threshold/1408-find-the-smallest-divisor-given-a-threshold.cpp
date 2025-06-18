class Solution {
public:

    int validornot(vector<int>& nums, int num, int threshold){
        long long sum = 0;
        for(int i = 0; i<nums.size(); i++) {
            sum += ceil(float(nums[i])/float(num));
            // cout << sum << endl;
        }
        // cout << sum << endl;
        if (sum > threshold) return false;
        else return true;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
         int start = 1; int end  = *max_element(nums.begin(), nums.end());
         while (start < end) {
            int mid = start + (end - start)/2;
            if (validornot(nums, mid, threshold)) end = mid;
            else start = mid + 1;
            // cout << "Start: " << start;
            // cout << " End: " << end << endl;
         }
         return start;
 

    }
};
