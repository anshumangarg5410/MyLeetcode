class Solution {
public:
    int lengthAfterTransformations(string s, int t) {
        const int MOD = 1000000007;
        vector<long long> freq(26, 0);
        for(char i : s) freq[i - 'a']++;
        while (t > 0) {
            vector<long long> tfreq(26, 0);
                for (int i = 0; i < 26; ++i) {
                    if (i == 25) {
                        tfreq[0] = (tfreq[0] + freq[25]) % MOD;
                        tfreq[1] = (tfreq[1] +  freq[25]) % MOD;
                    } else {
                        tfreq[i + 1] = (tfreq[i+1] + freq[i]) % MOD;
                    }
                }
            t--;
            freq = tfreq;
        }
        long long final = 0;
        for(int i : freq) final = (final + i) % MOD;
        return final;
        
    }
};