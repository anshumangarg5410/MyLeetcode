class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        int le = mat.size(), re = mat[0].size();
        vector<int> result;

        int l = 0, r = 0;

        while (result.size() < le * re) {

            while (l >= 0 && r < re) {
                result.push_back(mat[l][r]);
                l--;
                r++;
            }

            if (r >= re) { 
                l += 2;  
                r = re - 1;
            } else {     
                l = 0;   
            }

            if (result.size() >= le * re) break;


            while (r >= 0 && l < le) {
                result.push_back(mat[l][r]);
                l++;
                r--;
            }

            if (l >= le) { 
                r += 2;  
                l = le - 1;
            } else {     
                r = 0;    
            }
        }
        return result;
    }
};