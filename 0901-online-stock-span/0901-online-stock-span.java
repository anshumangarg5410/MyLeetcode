class StockSpanner {
    int i;
    Stack<Integer> st;
    Stack<Integer> ind;

    public StockSpanner() {
        st = new Stack<>();
        ind = new Stack<>();
        i = 0;
    }
    
    public int next(int price) {
        int ans = 0;

        while (!st.isEmpty() && st.peek() <= price) {
            st.pop();
            ind.pop();
        }

        if (st.isEmpty()) {
            ans = i + 1;
        }
        else {
            ans = i - (ind.peek());
        }

        st.push(price);
        ind.push(i++);

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */