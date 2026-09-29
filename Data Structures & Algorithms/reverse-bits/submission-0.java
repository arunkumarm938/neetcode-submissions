class Solution {
    public int reverseBits(int n) {
        int i = 31;
        int res = 0;
        while(i >= 0){
            if((n & 1) == 1){
                res |= (1 << i);
            }
            i--;
            n = n >>>1;
        }
        return res;
    }
}
