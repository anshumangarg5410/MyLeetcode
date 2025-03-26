/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:

    int guessNumber(int n) {
        // int m = n;
        // while (1){
        //     if (guess(m) == 0) return m;
        //     else if (guess(m) == 1) m++;
        //     else m--;
        // }

        //using binary search! 

        int start = 0; int last = n;
        while (start <= last){
            int mid = start + (last - start)/2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) start = mid + 1;
            else last = mid - 1;
        }
        return -1;
    }

};