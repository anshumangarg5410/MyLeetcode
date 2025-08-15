class Solution {
public:
    string reverseWords(string s) {
        reverse(s.begin(), s.end());
        int start = 0; int end = s.size();

        for(int i = 0; i<s.size(); i++) {
            while (i < s.size() && s[i] != ' ') i++;
            end = i;
            reverse(s.begin() + start, s.begin() + end);
            start = i + 1;
        }

        //removing spaces

        //starting spaces
        start = 0; 
        while (s[start] == ' ') start++;
        s.erase(0, start);

        //ending spaces
        end = s.size() -1;
        while (s[end] == ' ') end--;
        s.erase(end + 1, s.size() - end - 1);

        //mid spaces
        for (int i = 0; i < s.size() - 1; ) {
            if (s[i] == ' ' && s[i + 1] == ' ') {
                s.erase(i, 1);
            } else {
                i++;
            }
        }


        return s;
    }
};