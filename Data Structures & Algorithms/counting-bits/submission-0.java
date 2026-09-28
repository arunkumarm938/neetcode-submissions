class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            int op = 0;
            int j = i;
            while(j>0){
                if((j & 1) == 1){
                    op++;
                }
                j >>>= 1;
            }
            res[i] = op; 
        }
        return res;
    }
}
