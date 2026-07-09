class MedianFinder {

    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;

    public MedianFinder() {
        pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
        pqMin = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        pqMax.add(num);
        if (
            pqMax.size() - pqMin.size() > 1 ||
            !pqMin.isEmpty() &&
            pqMax.peek() > pqMin.peek()
        ) {
            pqMin.add(pqMax.poll());
        }
        if (pqMin.size() - pqMax.size() > 1) {
            pqMax.add(pqMin.poll());
        }
    }
    
    public double findMedian() {
        if (pqMin.size() == pqMax.size()) {
            return (double) (pqMin.peek() + pqMax.peek()) / 2;
        } else if (pqMax.size() > pqMin.size()) {
            return (double) pqMax.peek();
        } else {
            return (double) pqMin.peek();
        }
    }
}
