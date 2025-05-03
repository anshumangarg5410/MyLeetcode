class Solution {
public:

    int wordcounter(string s) {
        int size = s.size(); int count = 1;
        int temp = 0; int start;
        while (temp < size) {
            if (s[temp] != ' ') {
                start = temp; break;
            } temp++;
        }
        for(int i = start; i<size; i++){
            if (s[i] == ' ') count++;
        }
        return count;
    }
    int mostWordsFound(vector<string>& sentences) {
        int rslt = INT_MIN;
        for(string i : sentences) {
            rslt = max(rslt, wordcounter(i));
        }
        return rslt;
    }

};