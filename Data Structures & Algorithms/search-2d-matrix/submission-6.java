class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0;
        int b = m-1;
        int l =0;
        int r = n - 1;
        int row = -1;
        while(t<=b){
            int mid = (b+t) / 2;
            System.out.println(t+" "+b+" "+mid+" "+matrix[mid][0]+" "+target);
            if(matrix[mid][0] > target){
                b = mid-1;
            }else if(matrix[mid][n-1] < target){
                t = mid+1;
            }else{
                row = mid;
                break;
            }
            System.out.println(t+" "+b);
        }
        if(row == -1 && t == 0){
            row = 0;
        }else if(row == -1 && b == m-1){
            row = m-1;
        }else if(row==-1){
            row=0;
        }
        System.out.println(row);
        while(l <= r){
            int mid = (r + l)/2;
            System.out.println(l+" "+r+" "+mid+" "+matrix[row][mid]);
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                l = mid +1;
            }else{
                r = mid -1;
            }
        }
        return false;
    }
}
