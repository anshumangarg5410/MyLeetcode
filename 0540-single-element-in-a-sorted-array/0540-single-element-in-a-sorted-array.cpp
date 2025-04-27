class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        // int result = 0;
        // for(int i : nums) result ^= i;
        // return result;

        if (nums.size() == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];

        int start =0; int end = nums.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            cout << "mid: " << nums[mid] << " at "<< mid << endl;

            if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];
            //even odd
            if (nums[mid] == nums[mid + 1]){
                if (mid %2 != 0){ //1
                    end = mid;
                    cout << "cond 1, end = " << mid << " nums = " << nums[mid] << endl;
                }
                else { //2
                    start = mid + 1;
                    cout << "cond 2, start = " << mid + 1 << " nums = " << nums[mid] << endl;
                    } 
            }
            else if (nums[mid] == nums[mid - 1]){
                if (mid %2 == 0) { //3
                    end = mid;
                    cout << "cond 3, end = " << mid << " nums = " << nums[mid] << endl;
                }
                else { //4
                    start = mid + 1;
                    cout << "cond 4, start = " << mid + 1 << " nums = " << nums[mid] << endl;
                } 
            } 
        }
        return 0;

    }
};