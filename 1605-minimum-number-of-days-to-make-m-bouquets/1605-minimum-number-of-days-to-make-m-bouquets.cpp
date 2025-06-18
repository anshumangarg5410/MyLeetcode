class Solution {
public:

    bool validornot(vector<int> &arr, int day, int k, int m) {
        int bookeh = 0; int flowers = 0;
        for(int i = 0; i<arr.size(); i++) {
            if (arr[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bookeh++;
                    flowers = 0; 
                }
            } else flowers = 0; 
        }
        return bookeh >= m;
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        long long total = (m * 1ll) * (k * 1ll);
        if (total > bloomDay.size()) return -1;
        int start = *min_element(bloomDay.begin(), bloomDay.end()); 
        int end = *max_element(bloomDay.begin(), bloomDay.end());
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (validornot(bloomDay, mid, k, m)) end = mid-1;
            else start = mid + 1;
        }
        return start;
    }
};