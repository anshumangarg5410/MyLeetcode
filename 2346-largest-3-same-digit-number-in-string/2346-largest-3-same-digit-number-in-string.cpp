class Solution {
public:
    string largestGoodInteger(string num) {
        string ans = "";
        string temp = string(1, num[0]);
        int count = 1; 
        for (int i = 1; i < num.size(); i++) {
            if (num[i] == temp[0]) { 
                temp += num[i];
                count++;
            } 
            else { 
                temp = string(1, num[i]);
                count = 1;
            }

            if (count == 3) { 
                ans = max(ans, temp);
            }
        }
        return ans;
    }
};