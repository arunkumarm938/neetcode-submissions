class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
         for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, visited, r, c, board.length, board[0].length, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
         return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n, char[] arr, int k){
        if(k == arr.length){
            return true;
        }
        if(board[i][j] == arr[k]){
            visited[i][j] = true;
            boolean left = false, right = false, top = false, bottom = false;
            if(i>0 && !visited[i-1][j]){
                left = dfs(board, visited, i-1, j, m, n, arr, k+1);
            }
            if(!left){
                if(i < m-1 && !visited[i+1][j]){
                    right = dfs(board, visited, i+1, j, m, n, arr, k+1);
                }
            }else{
                return left;
            }
            if(!right){
                if(j > 0 && !visited[i][j-1]){
                    bottom = dfs(board, visited, i, j-1, m, n, arr, k+1);
                }
            }else{
                return right;
            }
            if(!bottom){
                if(j < n - 1 && !visited[i][j+1]){
                    top = dfs(board, visited, i, j+1, m, n, arr, k+1);
                }
            }else{
                return bottom;
            }
            visited[i][j] = false;
            return visited[i][j] || top || k == arr.length - 1;
        }
        return false;
    }
}
