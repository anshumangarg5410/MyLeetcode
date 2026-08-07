class Solution {

    public int remFirstDig(int n) {
        int m = 0;

        while (n > 0) {
            m = m * 10 + n % 10;
            n /= 10;
        }

        m /= 10;
        n = 0;

        while (m > 0) {
            n = n * 10 + m % 10;
            m /= 10;
        }

        return n;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int startDig = 0;
        int temp = low;

        while (temp > 0) {
            startDig++;
            temp /= 10;
        }

        int num = 1;
        int additor = 2;

        for (int i = 0; i < startDig - 1; i++, additor++) {
            num = num * 10 + additor;
        }
        while (startDig <= 9) {

            if (num >= low && num <= high) ans.add(num);

            if (additor == 10) {
                startDig++;

                if (startDig > 9) break;

                num = 1;
                additor = 2;

                for (int i = 0; i < startDig - 1; i++, additor++) {
                    num = num * 10 + additor;
                }

                continue;
            }

            num = remFirstDig(num) * 10 + additor;
            additor++;
        }

        return ans;
    }
}