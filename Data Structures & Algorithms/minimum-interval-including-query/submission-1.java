class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            int firstCompare = Integer.compare(a[0], b[0]);
            if (firstCompare == 0) {
                int diffA = a[1] - a[0];
                int diffB = b[1] - b[0];
                return Integer.compare(diffA, diffB);
            }
            return firstCompare;
        });
        int[] res = new int[queries.length];
        for(int i=0;i<res.length;i++){
            int j=0;
            int minRange = Integer.MAX_VALUE;
            while(j < intervals.length && intervals[j][0] <= queries[i]){
                if(intervals[j][1] < queries[i]){
                    j++;
                    continue;
                }
                if(intervals[j][0] <= queries[i] && intervals[j][1] >= queries[i]){
                    minRange = Math.min(minRange, intervals[j][1] - intervals[j][0]+1);
                }
                j++;
            }
            res[i]= minRange == Integer.MAX_VALUE ? -1 : minRange;
        }
        return res;
    }
}
