class MinStack {

    Stack<Integer> values;
    Stack<Integer> minPrefixes;

    public MinStack() {
        values = new Stack<>();
        minPrefixes = new Stack<>();
    }
    
    public void push(int val) {
        values.push(val);
        if (minPrefixes.empty()) {
            minPrefixes.push(val);
        } else {
            minPrefixes.push(Math.min(minPrefixes.peek(), val));
        }
    }
    
    public void pop() {
        values.pop();
        minPrefixes.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return minPrefixes.peek();
    }
}
