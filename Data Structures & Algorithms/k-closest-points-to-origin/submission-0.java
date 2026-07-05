class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
    (a, b) -> Double.compare(
        Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2)), 
        Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2))
    )
);
        for(int[] i:points){
            q.offer(i);
        }
        int[][] res = new int[k][1];
        for(int i=0;i<k;i++){
            res[i]=q.poll();
        }
        return res;
    }
}
