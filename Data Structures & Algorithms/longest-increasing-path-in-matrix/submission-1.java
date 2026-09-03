class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i, j, matrix, dp, m, n);
            }
        }
        int max = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    private int dfs(int i, int j,int[][] matrix, int[][] dp, int m, int n){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int max = 1;
        if(i < m-1 && matrix[i][j] < matrix[i+1][j]){
            max = Math.max(max, dfs(i+1, j, matrix, dp, m, n)+1);
        }
        if(i > 0 && matrix[i][j] < matrix[i-1][j]){
            max = Math.max(max, dfs(i-1, j, matrix, dp, m, n)+1);
        }
        if(j < n-1 && matrix[i][j] < matrix[i][j+1]){
            max = Math.max(max, dfs(i, j+1, matrix, dp, m, n)+1);
        }
        if(j > 0 && matrix[i][j] < matrix[i][j-1]){
            max = Math.max(max, dfs(i, j-1, matrix, dp, m, n)+1);
        }
        dp[i][j] = max;
        return dp[i][j];
    }
}
