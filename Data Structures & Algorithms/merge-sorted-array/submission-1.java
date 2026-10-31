class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       if(n == 0){
        return;
       }
       int i = 0;
       while(i < m ){
        while(i < m && nums1[i] <= nums2[0]){
            i++;
        }
        if(i >= m){
            break;
        }
        int temp = nums1[i];
        nums1[i++] = nums2[0];
        int j=1;
        while(j < n && temp > nums2[j]){
            nums2[j-1] = nums2[j++];
        }
        nums2[j-1] = temp;
       }
       int j = 0;
       while(i < m + n && j < n){
        nums1[i++] = nums2[j++];
       }
    }
}