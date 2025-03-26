class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> output;
        int i = 0, j=0, k=0;
        while (i < nums1.size() && j < nums2.size()){
            if (nums1[i] > nums2[j]) output.push_back(nums2[j++]);
            else output.push_back(nums1[i++]);
        }
        while (i < nums1.size()) output.push_back(nums1[i++]);
        while (j < nums2.size()) output.push_back(nums2[j++]);

        for (int i : output) cout << i << endl;
        double median;
        if (output.size() %2 != 0) median = output[output.size() / 2];
        else median = (output[(output.size()/2) - 1] + output[output.size()/2])/2.000;
        return median;
    }
};