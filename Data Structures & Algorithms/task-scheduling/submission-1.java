class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            pq.offer(e.getValue());
        }
        Queue<int[]> q = new LinkedList<>();
        int t = 0;
        while(pq.size()!=0 || q.size() != 0){
           t++;
           if(pq.size() == 0){
            int[] arr = q.peek();
            t = arr[1];
           }else{
            int i = pq.poll()-1;
            if(i > 0){
                q.offer(new int[]{i,t+n});
            }
           }
            if(!q.isEmpty() && (q.peek()[1] == t)){
                pq.offer(q.poll()[0]);
            }
        }
        return t;
    }
}
