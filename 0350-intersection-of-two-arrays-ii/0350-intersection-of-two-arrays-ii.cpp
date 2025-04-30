class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> freqency;
        vector<int> result;
        for(int i : nums1) freqency[i]++;
        for(int i : nums2){
            if (freqency[i] > 0) {
                result.push_back(i);
                freqency[i]--;
            }
        }
        return result;
    }
};