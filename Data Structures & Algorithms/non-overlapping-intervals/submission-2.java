class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });
        int prevEnd = intervals[0][1];
        int i = 1;
        int count = 0;
        while(i < intervals.length){
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
                i++;
                continue;
            }
            count++;
            prevEnd = Math.min(prevEnd, intervals[i][1]);
            i++;
        }
        return count;
    }
}
