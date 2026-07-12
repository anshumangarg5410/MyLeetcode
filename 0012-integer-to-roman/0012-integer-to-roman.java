class Solution {

    public int remFirstDigit(int num) {
        int ans = 0;

        while (num > 0) {
            ans = ans * 10 + num%10;
            num /= 10;
        }

        ans /= 10;
        num = ans;
        ans = 0;

        if (ans % 10 == 0) {

        }

        while (num > 0) {
            ans = ans * 10 + num%10;
            num /= 10;
        }

        return ans;
    }

    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();

        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        StringBuilder ans = new StringBuilder();
        // int n = num;
        StringBuilder n = new StringBuilder();
        n.append(num);
        int length = n.length();

        // while (n > 0) {
        //     length++;
        //     n /= 10;
        // }

        // n = num;
        int div = (int)Math.pow(10.00, (double)(length - 1));

        while (div > 0) {
            // int nmber = n / div;
            int nmber = n.charAt(0) - '0';
            // System.out.println("nmber : " + nmber + " and div : " + div + " and orig number : " + n);

            if (nmber <= 3) {
                for(int i = 0; i < nmber; i++) ans.append(map.get(div));
            }
            else if (nmber == 4) {
                ans.append(map.get(div));
                ans.append(map.get(div * 5));
            }
            else if (nmber == 5) {
                ans.append(map.get(div*5));
            }
            else if (nmber > 5 && nmber <= 8) {
                ans.append(map.get(div*5));
                for(int i = 5; i < nmber; i++) ans.append(map.get(div));
            }
            else if (nmber == 9) {
                ans.append(map.get(div));
                ans.append(map.get(div * 10));
            }
            else {
                System.out.println("error");
            }

            // n = remFirstDigit(n);
            n.deleteCharAt(0);
            div /= 10;

        }

        return ans.toString();

    }
}