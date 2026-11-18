class Solution {
    public int magicalString(int n) {

        if (n <= 3) return 1;

        StringBuilder s = new StringBuilder("122");
        int noOfOnes = 1;
        int current = 1;

        int pointer = 2;

        while (pointer < n) {
            int count = s.charAt(pointer) - '0';
            for (int j = 0; j < count; j++) {
                s.append(current);
                if (current == 1 && s.length() <= n) {
                    noOfOnes++;
                }
            }

            current = (current == 1) ? 2 : 1;
            pointer++;
        }

        return noOfOnes;

    }
}
