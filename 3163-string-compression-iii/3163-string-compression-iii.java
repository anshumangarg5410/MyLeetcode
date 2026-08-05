class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int freq = 0;
        char present = word.charAt(0);

        for(int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == present && freq < 9) {
                freq++;
            }
            else {
                sb.append(freq);
                sb.append(present);

                freq = 1;
                present = word.charAt(i);
            }
        }

        sb.append(freq);
        sb.append(present);

        return sb.toString();
    }
}
