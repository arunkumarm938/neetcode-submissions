class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[1];
        res[0] = 0;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0,0,m-1,n-1, dp);
    }
    private int dfs(int i, int j, int m, int n, int[][] dp){
        if(i == m && j == n){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = 0;
        int right = 0;
        if(i < m){
            down = dfs(i+1, j, m, n, dp);
        }
        if(j < n){
            right = dfs(i, j+1, m, n, dp);
        }
        dp[i][j] = down + right;
        return dp[i][j];
    }
}
