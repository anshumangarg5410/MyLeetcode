class Solution {
    public int compress(char[] chars) {
        int pointer1 = 0;
        int pointer2 = 0;
        int total = 0;

        for (; pointer1 < chars.length;) {
            char present = chars[pointer1];
            int fq = 0;

            while (pointer1 < chars.length && chars[pointer1] == present) {
                fq++;
                pointer1++;
            }

            

            if (fq > 1) {
                chars[pointer2++] = present;
                total++;

                if (fq > 9) {
                    char[] dig = Integer.toString(fq).toCharArray();
                    for(char d : dig) {
                        chars[pointer2++] = d;
                    }
                    
                    total += dig.length;

                }
                else {
                    chars[pointer2++] = (char)(fq + '0');
                    total++;
                }

            }
            else {
                chars[pointer2++] = present;

                total++;
            }

        }

        return total;
    }
}
