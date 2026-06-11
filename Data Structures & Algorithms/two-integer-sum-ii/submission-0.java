class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] op = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                op[0]=i+1;
                op[1]=j+1;
                return op;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return op;
    }
}
