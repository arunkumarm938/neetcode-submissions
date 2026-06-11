class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int i = 0;
        int j = heights.length - 1;
        while(i < j){
            int curr = (j - i) * Math.min(heights[i],heights[j]);
            result = Math.max(result, curr);
            if(heights[i]<heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
