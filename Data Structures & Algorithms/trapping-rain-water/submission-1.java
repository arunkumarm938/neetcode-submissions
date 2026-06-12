class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length -1;
        int op = 0;
        int lm = 0;
        int rm = r;
        while(l<r) {
            if (height[l]<=height[r]){
               l++;
               if(height[l]>= height[lm]){
                   lm=l;
               }else{
                   op+= height[lm]- height[l];
               }
            }else{
               r--;
               if(height[r]>=height[rm]){
                 rm = r;
               } else {
                 op+= height[rm]-height[r];
               }
            }
        }
        return op;
    }
}
