class Solution {
public:
    bool isPalindrome(int x) {
        // if (x < 0) return false;
        // vector<int> myvec; vector<int> revvec;
        // int num = x;
        // while(num > 0){
        //     myvec.insert(myvec.begin(), num%10);
        //     revvec.push_back(num%10);
        //     num = num/10;
        // }
        // if (myvec == revvec) return true;
        // else return false;

        //otherlogic!!
        
        if (x < 0 || (x%10 == 0 && x != 0)) return false;
        int revhalf = 0;
        while (x > revhalf){
            revhalf = revhalf * 10 + x%10;
            x /= 10;
        }
        return x == revhalf || x == revhalf/10;
    };
};