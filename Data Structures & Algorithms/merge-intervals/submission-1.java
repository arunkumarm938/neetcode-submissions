class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
       List<int[]> list = new ArrayList<>();
       int prevMin = intervals[0][0];
       int prevMax = intervals[0][1];
       for(int i=1;i<intervals.length;i++){
            if(prevMax < intervals[i][0]){
                list.add(new int[]{prevMin, prevMax});
                prevMin = intervals[i][0];
                prevMax = intervals[i][1];
            }else{
                int[] arr = new int[2];
                prevMin = Math.min(prevMin, intervals[i][0]);
                prevMax = Math.max(prevMax, intervals[i][1]);
            }
       }
       list.add(new int[]{prevMin, prevMax});
       return list.toArray(new int[list.size()][]); 
    }
}
