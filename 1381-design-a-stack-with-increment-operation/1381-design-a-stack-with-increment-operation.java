class CustomStack {
    
    private int[] incs;
    private int[] values;
    private int index;
    private int n;
     public CustomStack(int maxSize) {
        n = maxSize;
        index = -1;
        incs = new int[n];
        values = new int[n];
    }

    public void push(int x) {
        if (index + 1 == n) return;
        index++;
        values[index] = x;
        incs[index] = 0;
        
    }

    public int pop() {
       if (index == -1) return -1;
        int first = values[index];
        int increment = incs[index];
        index--;
        if (index >= 0) {
         incs[index] += increment;   
        }
        return first + increment;
    }

    public void increment(int k, int val) {
        int i = Math.min(k - 1,  index);
        if (i >= 0)
            incs[i] += val;
    }
}
