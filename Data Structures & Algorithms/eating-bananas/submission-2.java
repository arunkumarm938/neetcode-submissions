class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(max, i);
        }
        int l = 1, r = max, result = max;
        while(l<=r){
            int m = (l + r)/2;
            int count = 0;
            for(int i: piles){
                count += (int) Math.ceil((double)i/m);
            }
            if(count <= h){
                r = m-1;
                result = m;
            }else if(count > h){
                l = m+1;
            }else{
                return m;
            }
        }
        return result;
    }
}
