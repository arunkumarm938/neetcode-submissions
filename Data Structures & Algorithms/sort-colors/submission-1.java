class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        while(blue >= 0 && nums[blue] == 2){
            blue--;
        }
        while(red < nums.length && nums[red] == 0){
            red++;
        }
        int white = red;
        while(white <= blue){
            System.out.println(Arrays.toString(nums));
            if(nums[white] == 1){
                white++;
                continue;
            }
            if(nums[white] == 0){
                int temp = nums[red];
                nums[red++] = 0;
                nums[white++] = temp;
            }else{
                int temp = nums[blue];
                nums[blue--] = 2;
                nums[white] = temp;
            }
        }
    }
}