class Solution {
public:
    vector<int> findPeaks(vector<int>& mountain) {
        vector<int> rslt;
        for(int i = 1; i<mountain.size()-1; i++){
            if (mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]) rslt.push_back(i);
        }
        return rslt;
        // vector<int> rslt; int l = 1, r = mountain.size() - 2;
        // while (l <= r){
        //     if (l == r) if (mountain[l] > mountain[l-1] && mountain[l] > mountain[l+1]) rslt.push_back(l);
        //     if (mountain[l] > mountain[l-1] && mountain[l] > mountain[l+1]) rslt.push_back(l);
        //     if (mountain[r] > mountain[r-1] && mountain[r] > mountain[r+1]) rslt.push_back(r);
        //     l++, r--;
        // }
        // return rslt;
    }
};

