class StockSpanner {
    Stack<int[]> stack;  // Stack to store [price, span] pairs
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;  // Minimum span is 1 (current day)
        
        // Pop elements from stack while they're less than or equal to current price
        // and add their spans to current span
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1];
            stack.pop();
        }
        
        // Push current price and its span to stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}