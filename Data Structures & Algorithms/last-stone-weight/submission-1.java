class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for(int i: stones){
            q.offer(i);
        }
        int st = q.poll();
        while(q.size() > 0){
            int sec = q.poll();
            int res = st - sec;
            if(res > 0){
                q.offer(st - sec);
            }
            if(q.size() > 0){
                st = q.poll();
            }else{
                st = 0;
            }
        }
        return st;
    }
}
