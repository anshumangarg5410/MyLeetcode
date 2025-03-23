class Solution {
public:

    int happynum(int n){
        int sum = 0;
        while(n>0){
            sum += pow((n%10), 2);;
            n /= 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        if (n == 1 || n == 0) return true;
        unordered_set<int> seen;
        while(happynum(n) != 1){
            n = happynum(n);
            if (seen.find(n) != seen.end()) return false;
            seen.insert(n);
        }
        return true;
    }
};