class Solution {
public:
    void digitinc(vector<int>& digits, int i){
        if (digits[i] == 9){
            if (i == 0) {
                digits.insert(digits.begin(), 1);
                digits[i+1] = 0;
                return;
            }
            digits[i] = 0;
            digitinc(digits, i-1);
        }
        else {digits[i]++; return;}
    }

    vector<int> plusOne(vector<int>& digits) {
        int i = digits.size() -1;
        digitinc(digits, i);
        return digits;
        // for(i; i>=0; i--){
        //     if(digits[i] < 9) {
        //         digits[i]++;
        //         return digits;
        //     }
        //     digits[i] = 0;
           
        // }
        // digits.insert(digits.begin(), 1);

        // return digits;
    }
};