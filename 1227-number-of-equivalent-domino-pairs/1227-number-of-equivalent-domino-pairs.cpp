class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int rslt = 0;
        // for(int i = 0; i<dominoes.size(); i++){
        //     pair<int, int> target = {dominoes[i][0], dominoes[i][1]};
        //     for(int j = i+1; j<dominoes.size(); j++){
        //         if (target.first == dominoes[j][0] && target.second == dominoes[j][1] 
        //         || target.second == dominoes[j][0] && target.first == dominoes[j][1]) {
        //             rslt++;
        //         }
        //     }
        // }

        unordered_map<int, int> seentable;
        set<int> keys;
        for(int i = 0; i<dominoes.size(); i++){
            pair<int, int> target = {max(dominoes[i][0], dominoes[i][1]), min(dominoes[i][0], dominoes[i][1])};
            seentable[target.first * 10 + target.second]++; 
            keys.insert(target.first * 10 + target.second);
        }
        for(int i : keys){
            if (seentable[i] > 1) {
                rslt += seentable[i]*(seentable[i] - 1)/2;
            } 
        }
        return rslt;
    }
};