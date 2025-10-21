class Solution {
    public String convert(String s, int numRows) {
        String[] arr = new String[numRows];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        int direction = -1, iterator = 0;
        for (int i = 0; i<arr.length; i++) System.out.println(arr[i]);
        if (numRows == 1) return s;
        for (int i = 0; i<s.length(); i++) {
            if (iterator % (numRows - 1) == 0) direction *= -1;

            arr[iterator] += s.charAt(i);

            if (direction > 0) iterator++;
            else iterator--;

        }

        String anss = "";
        for (int i = 0; i < arr.length; i++) {
            anss += arr[i];
        }

        for (int i = 0; i<arr.length; i++) System.out.println(arr[i]);

        return anss;
        

    }
}