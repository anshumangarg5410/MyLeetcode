class Solution {
public:
    int maxProduct(int n) {
        int prod = 1; int size = 0;
        vector<int> vec; int cpy = n;
        while (cpy > 0) {
            size++; vec.push_back(cpy % 10); cpy /= 10;
        }
        sort(vec.begin(), vec.end(), greater<int>());
        return vec[0] * vec[1];

    }
};