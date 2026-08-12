class Solution {
    public int compareVersion(String version1, String version2) {
        int iterator1 = 0;
        int iterator2 = 0;

        while (iterator1 < version1.length() || iterator2 < version2.length()) {
            int num_1 = 0;
            int num_2 = 0;

            while (iterator1 < version1.length() && version1.charAt(iterator1) != '.') {
                num_1 = num_1*10 + (version1.charAt(iterator1) - '0');
                iterator1++;
            }
            iterator1++;

            while (iterator2 < version2.length() && version2.charAt(iterator2) != '.') {
                num_2 = num_2*10 + (version2.charAt(iterator2) - '0');
                iterator2++;
            }
            iterator2++;


            // System.out.println(num_1 + " " + num_2);
            if (num_1 > num_2) return 1;
            else if (num_1 < num_2) return -1;

        }

        return 0;
    }
}