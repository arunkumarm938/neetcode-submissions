class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> op = new HashSet<>();
        for(String word: words){
            for(int i=0;i< board.length;i++){
                for(int j=0;j< board[0].length;j++){
                    if(board[i][j] == word.charAt(0) && dfs(board.length, board[0].length, board, i, j, new boolean[board.length][board[0].length], word, 0)){
                        op.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(op);
    }
    private boolean dfs(int r, int c, char[][] board, int i, int j, boolean[][] visited, String word, int k){
        if(k == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= r || j >= c || visited[i][j] || word.charAt(k) != board[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean found = dfs(r, c, board, i+1, j, visited, word, k+1) ||
                        dfs(r, c, board, i-1, j, visited, word, k+1) ||
                        dfs(r, c, board, i, j-1, visited, word, k+1) ||
                        dfs(r, c, board, i, j+1, visited, word, k+1);
        visited[i][j] = false;
        return found;
    }
}
