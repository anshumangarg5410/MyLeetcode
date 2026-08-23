class Solution {
    public boolean sumGame(String num) {
        int len = num.length();

        int first = 0;
        int first_Qm = 0;
        int second = 0;
        int second_Qm = 0;

        for (int i = 0; i < len / 2; i++) {
            if (num.charAt(i) == '?') {
                first_Qm++;
                continue;
            }

            first += num.charAt(i) - '0';
        }

        for (int i = len / 2; i < len; i++) {
            if (num.charAt(i) == '?') {
                second_Qm++;
                continue;
            }

            second += num.charAt(i) - '0';
        }

        if ((first_Qm + second_Qm) % 2 == 1) return true;

        if (first - second == ((second_Qm - first_Qm) * 9) / 2) return false;

        return true;
    }
}