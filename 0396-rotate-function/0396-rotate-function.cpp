class Solution {
public:
    //brute force.. bekar approach => TLE
    // void reverse(vector<int> &arr, int s, int n) {
    //     int left = s, right = n - 1;
    //     while (left <= right) {
    //         int temp = arr[left];
    //         arr[left] = arr[right];
    //         arr[right] = temp;
    //         left++, right--;
    //     }
    // }

    // vector<int> rotate(vector<int> copy, int n, int k) {
    //     vector<int> arr = copy;
    //     if (k >= n) k = k % n;

    //     reverse(arr, 0, n);
    //     reverse(arr, 0, k);
    //     reverse(arr, k, n);

    //     return arr;

    // }
    int maxRotateFunction(vector<int>& nums) {
    //     int n = nums.size();
    //     int ans = 0;
    //     for(int i = 0; i<nums.size(); i++) {
    //         int tempans = 0;
    //         vector<int> neww = rotate(nums, n, i);
    //         for(int i : neww) cout << i << " ";
    //         cout << endl;
    //         for(int i = 0; i<nums.size(); i++) tempans += neww[i] * i;
    //         ans = max(ans, tempans);
    //     }
    //     return ans;


    //achi wali approach .. 
        int n = nums.size();
        int sum = 0; int ans = 0; int ini = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            ini += nums[i] * i;
        }
        ans = ini;
        for(int i = 0; i<n; i++) {
            ini = ini + sum - (n * nums[n-(i+1)]);
            ans = max(ini, ans);
        }
        return ans;

        
    }
};