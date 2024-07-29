class MedianFinder {
    PriorityQueue<Integer> smallPQ; //max heap
    PriorityQueue<Integer> largePQ; //min heap
    public MedianFinder() {
        smallPQ = new PriorityQueue<Integer>((a, b) -> (b - a));
        largePQ = new PriorityQueue<Integer>((a, b) -> (a- b));
    }
    
    public void addNum(int num) {
        smallPQ.add(num);
        while ((smallPQ.size() - largePQ.size() > 1) || 
        (!largePQ.isEmpty() && smallPQ.peek() > largePQ.peek())) {
            largePQ.add(smallPQ.poll());
        }
        while (largePQ.size() - smallPQ.size() > 1) {
            smallPQ.add(largePQ.poll());
        }

    }
    
    public double findMedian() {
        if (smallPQ.size() == largePQ.size()) {
            return (double) (largePQ.peek() + smallPQ.peek()) / 2;
        } else if (smallPQ.size() > largePQ.size()) {
            return (double) smallPQ.peek();
        } else {
            return (double) largePQ.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */