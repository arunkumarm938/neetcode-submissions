class KthLargest {

    PriorityQueue<Integer> q;
    int maxCapacity;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<Integer>();
        maxCapacity = k;
        for(int i:nums){
            q.offer(i);
            if(q.size()>k){
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>maxCapacity){
            q.poll();
        }
        return q.peek();
    }
}
