class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];

            if (val > 0) {
                st.push(val);
            } else {

                if (st.isEmpty()) {
                    st.push(val);
                } else {

                    if (st.peek() < 0) {
                        st.push(val);
                    } else if (st.peek() == Math.abs(val)) {
                        st.pop();
                        continue;
                    } else {

                        while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(val)) {
                            st.pop();
                        }

                        if (!st.isEmpty()) {

                            if (st.peek() == Math.abs(val)) {
                                st.pop();
                                continue;
                            }

                            if (st.peek() > 0) {
                                continue;
                            } else {
                                st.push(val);
                            }

                        } else {
                            st.push(val);
                        }
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        Stack<Integer> rev = new Stack<>();

        while (!st.isEmpty()) {
            rev.push(st.pop());
        }

        while (!rev.isEmpty()) {
            ans.add(rev.pop());
        }

        int[] anss = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            anss[i] = ans.get(i);
        }

        return anss;
    }
}