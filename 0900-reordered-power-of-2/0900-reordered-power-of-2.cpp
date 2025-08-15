class Solution {
public:
    bool reorderedPowerOf2(int n) {
        string number = to_string(n);
        sort(number.begin(), number.end());

        for (int i = 0; i<32; i++) {
            int powerof2 = (1 << i);
            string powerof2string = to_string(powerof2);
            sort(powerof2string.begin(), powerof2string.end());
            if (powerof2string == number) return true;
        }
        
        return false;
    }
};

