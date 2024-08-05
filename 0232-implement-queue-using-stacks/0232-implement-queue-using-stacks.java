class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
          if (second.isEmpty()) {
            interchange();
        }
        int toReturn = second.peek();
        second.pop();
        return toReturn;
    }
    
    public int peek() {
        if (second.isEmpty()) {
            interchange();
        }
        //if (second.isEmpty())
        return second.peek();
    }
    
    private void interchange() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }
    
    public boolean empty() {
        if (first.isEmpty() && second.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */