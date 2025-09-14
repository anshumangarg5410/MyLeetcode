#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxFreqSum(string s) {
        unordered_map<char, int> freq;
        for (char c : s) {
            freq[c]++;
        }

        string vowels = "aeiou";
        int vowel = 0, conso = 0;

        for (auto &p : freq) {
            char c = p.first;
            int f = p.second;
            if (vowels.find(c) != string::npos) {
                vowel = max(vowel, f);
            } else {
                conso = max(conso, f);
            }
        }

        return vowel + conso;
    }
};