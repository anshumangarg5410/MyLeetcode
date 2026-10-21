
import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int len = s.length();

        char[] origString = s.toCharArray();
        char[] sortedString = s.toCharArray();
        Arrays.sort(sortedString);

        if (Arrays.equals(origString, sortedString)) {
            return 0;
        }

        if (len == 2) {
            return -1;
        }

        boolean start = origString[0] == sortedString[0];
        boolean end = origString[len - 1] == sortedString[len - 1];

        if (start || end) {
            return 1;
        }

        if (origString[0] == sortedString[len - 1] && origString[len - 1] == sortedString[0]) {
            if (sortedString[len - 2] != sortedString[len - 1] && sortedString[0] != sortedString[1]) return 3;
        }

        return 2;
    }
}
