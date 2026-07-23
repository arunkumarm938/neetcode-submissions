class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    traverse(grid, visited, i, j, grid.length, grid[0].length);
                }
            }
        }
        return islands;
    }
    private void traverse(char[][] grid, boolean[][] visited, int i, int j, int r, int c){
        if(i >=0 && j >=0  && i < r&& j < c && !visited[i][j] && grid[i][j] == '1'){
            visited[i][j] = true;
            traverse(grid, visited, i+1, j, r,c);
            traverse(grid, visited, i-1, j, r,c);
            traverse(grid, visited, i, j+1, r,c);
            traverse(grid, visited, i, j-1, r,c);
        }
    }
}
