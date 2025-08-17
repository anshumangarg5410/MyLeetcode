class Solution {
public:

    string basekconversion(long long n, int k) {
        if (n == 0) return "0";
        string allcomb = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        string result = "";
        while (n > 0) {
            result += allcomb[n % k];
            n /= k;
        }
        reverse(result.begin(), result.end());
        return result;
    }

    bool palindromeornor(string n) {
        int start = 0, end = n.size() - 1;
        while (start < end) {
            if (n[start++] != n[end--]) return false;
        }
        return true;
    }

    long long kMirror(int k, int n) {
        int count = 0;
        long long sum = 0;

        for (int length = 1; count < n; length++) {
            int half = (length + 1) / 2;
            long long start = pow(10, half - 1);
            long long end = pow(10, half);

            for (long long num = start; num < end && count < n; num++) {
                string startingpart = to_string(num);
                string endingpart = startingpart;
                reverse(endingpart.begin(), endingpart.end());

                string palindrome;
                if (length % 2 == 0) {
                    palindrome = startingpart + endingpart;
                } else {
                    palindrome = startingpart + string(endingpart.begin() + 1, endingpart.end());
                }

                long long number = stoll(palindrome);
                if (palindromeornor(basekconversion(number, k))) {
                    sum += number;
                    count++;
                }
            }
        }

        return sum;
    }
};