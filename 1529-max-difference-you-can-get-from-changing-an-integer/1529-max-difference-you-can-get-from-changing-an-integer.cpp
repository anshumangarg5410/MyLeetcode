class Solution {
public:
    int maxDiff(int num) {
        //generating maximum number
        string maximum_number = to_string(num);
        int target_index = 0;
        while (maximum_number[target_index] == '9' ) target_index++;
        int target = maximum_number[target_index];
        for (int i = 0; i<maximum_number.size(); i++) {
            if (maximum_number[i] == target) maximum_number[i] = '9';
        }

        //generating minimum number
        string minimum_number = to_string(num);
        target_index = 0;
        while (minimum_number[target_index] == '0' || minimum_number[target_index] == '1' ) target_index++;
        target = minimum_number[target_index];
        for (int i = 0; i<minimum_number.size(); i++) {
            if (target_index != 0) {
                if (minimum_number[i] == target) minimum_number[i] = '0';
            }
            else {
                if (minimum_number[i] == target) minimum_number[i] = '1';
            }
        }

        long long max = stoll(maximum_number);
        long long min = stoll(minimum_number);

        return max - min;
        
    }
};