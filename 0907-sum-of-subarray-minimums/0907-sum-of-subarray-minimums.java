class Solution {

    static int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {

        int[] arr_left = new int[arr.length];
        int[] arr_right = new int[arr.length];

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while (!left.isEmpty() && arr[left.peek()] > arr[i]) {
                left.pop();
            }

            if (left.isEmpty()) {
                arr_left[i] = -1;
            }
            else {
                arr_left[i] = left.peek();
            }

            left.push(i);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            while (!right.isEmpty() && arr[right.peek()] >= arr[i]) {
                right.pop();
            }

            if (right.isEmpty()) {
                arr_right[i] = arr.length;
            }
            else {
                arr_right[i] = right.peek();
            }

            right.push(i);
        }

        // for (int i : arr_left) System.out.print(i + " ");
        // System.out.println(); 
        // for (int i : arr_right) System.out.print(i + " "); 

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            long leftt = i - arr_left[i];
            long rightt = arr_right[i] - i;

            ans = (ans + (arr[i] * leftt * rightt) % MOD) % MOD;
        }

        return (int) ans;

    }
}