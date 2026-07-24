class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int[] area = new int[]{0};
                    traverse(grid, visited, i, j, grid.length, grid[0].length, area);
                    if(maxArea < area[0]){
                        maxArea = area[0];
                    }
                }
            }
        }
        return maxArea;
    }
    private void traverse(int[][] grid, boolean[][] visited, int i, int j, int r, int c, int[] area){
        if(i >=0 && j >=0  && i < r&& j < c && !visited[i][j] && grid[i][j] == 1){
            visited[i][j] = true;
            area[0]++;
            traverse(grid, visited, i+1, j, r,c, area);
            traverse(grid, visited, i-1, j, r,c, area);
            traverse(grid, visited, i, j+1, r,c, area);
            traverse(grid, visited, i, j-1, r,c, area);
        }
    }
}
