class Solution {
    public String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int[] count = new int[s.length()];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            sb.append(current);
            index++;

            if (index > 0 && sb.charAt(index) == sb.charAt(index - 1)) {
                count[index] = count[index - 1] + 1;
            } else {
                count[index] = 1;
            }

            if (count[index] == k) {

                sb.delete(index - k + 1, index + 1);
                index -= k;
            }
        }

        return sb.toString();
    }
}