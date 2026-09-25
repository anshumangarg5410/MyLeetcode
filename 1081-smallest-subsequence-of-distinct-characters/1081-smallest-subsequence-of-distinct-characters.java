import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
                if (!stack.isEmpty()) System.out.println((char)stack.peek());
            }

            stack.push(ch);
            // System.out.print("All chars: ");
            // for(char i : stack){
            //     System.out.print(i + " ");
            // }
            // System.out.println();
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.remove(0));   
        }

        return ans.toString();
    }
}

