class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] op = new int[nums.length];
        op[0] = 1;
        int prefixProduct = nums[0];
        for(int i=1;i<nums.length;i++){
            op[i]=prefixProduct;
            prefixProduct*=nums[i];
        }
        int postfixProduct = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            op[i]*=postfixProduct;
            postfixProduct = nums[i]*postfixProduct;
        }
        return op;
    }
}  
