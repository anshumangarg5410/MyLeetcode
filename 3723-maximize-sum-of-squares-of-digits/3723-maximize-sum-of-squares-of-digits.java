class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder s = new StringBuilder();

        while (sum > 9) {
            s.append(9);
            sum -= 9;
            num--;
        }

        if (sum > 0) {
            s.append(sum);
            num--;
            sum = 0;
        }

        while (num > 0) {
            s.append(0);
            num--;
        }

        if (num < 0) return "";
        return s.toString();
    }
}