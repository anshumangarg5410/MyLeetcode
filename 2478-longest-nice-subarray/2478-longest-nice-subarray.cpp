class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        int maxLen = 0;

        for(int j = 0; j < nums.size(); j++) {
            vector<int> nicesubarray;
            for(int i = j; i < nums.size(); i++) {
                bool isNice = true;
                for(int k = 0; k < nicesubarray.size(); k++) {
                    if ((nicesubarray[k] & nums[i]) != 0) {
                        isNice = false;
                        break;
                    }
                }
                if (!isNice) break;
                nicesubarray.push_back(nums[i]);
                maxLen = max(maxLen, (int)nicesubarray.size());
            }
        }

        return maxLen;
    }
};