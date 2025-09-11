class Solution {
public:
    string sortVowels(string s) {
        map<char, int> vowels;

        for (char c : s) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels[c]++;
            }
        }


        auto current = vowels.begin();


        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {

                s[i] = current->first;     
                current->second--;       

                if (current->second == 0) {
                    current = vowels.erase(current); 
                }
            }
        }

        return s;
    }
};