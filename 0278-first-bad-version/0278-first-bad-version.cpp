// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int start = 0; int end = n;

    //logic 1
        // while (start <= end){
        //     int mid = start + (end - start)/2;
        //     if (isBadVersion(mid) == true){
        //         if (mid - 1 > 0) {
        //             if (isBadVersion(mid-1) == false) return mid;
        //             else end = mid - 1;
        //         }
        //         else return mid;
        //     }
        //     else start = mid + 1;
        // }
        // return 0;

    //logic 2
        while (start < end){
            int mid = start + (end - start)/2;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return start;

    }


};