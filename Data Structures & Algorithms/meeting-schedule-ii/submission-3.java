/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0){
            return 0;
        }
        List<Integer> stList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        for(Interval i:intervals){
            stList.add(i.start);
            endList.add(i.end);
        }
        Collections.sort(stList);
        Collections.sort(endList);
        int count = 0;
        int maxCount = 0;
        int i=0;
        int j=0;
        while(i < intervals.size() && j < intervals.size()){
            if(stList.get(i) < endList.get(j)){
                count++;
                i++;
                maxCount = Math.max(count, maxCount);
            }else{
                j++;
                count--;
            }
        }
        return maxCount;
    }
}
