class MinStack {
    Stack<Long> stack;
    long min = 0;

    public MinStack() {
        stack = new Stack<Long>();
    }
    
    public void push(int val) {
        if(stack.size()==0){
            stack.push(0L);
            min = val;
        }else{
            stack.push(val - min);
            if (val < min) {
                min = val;
            }
        }
        
    }
    
    public void pop() {
        long pop = stack.pop();
        if(pop < 0){
            min = min - pop;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top < 0){
            return (int) (min);
        }else{
            return (int) (min + top);
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
