class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean freshFruitFound = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }if(grid[i][j] == 1){
                    freshFruitFound = true;
                }
            }
        }
        if(q.size() == 0){
            return freshFruitFound?-1:0;
        }
        int time = bfs(q, grid);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
    private int bfs(Queue<int[]> q, int[][] grid){
        int time = 0;
        while(q.size()!=0){
            int s = q.size();
            boolean freshFruitFound = false;
            for(int i=0;i<s;i++){
                int[] rottenFruit = q.poll();
                boolean temp = addAdjacentFreshFruitToQueue(q,rottenFruit[0], rottenFruit[1], grid);
                if(temp){
                    freshFruitFound = true;
                }
            }
            if(freshFruitFound){
                time++;
            }
        }
        return time;
    }
    private boolean addAdjacentFreshFruitToQueue(Queue<int[]> q, int r, int c, int[][] grid){
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean freshFruitFound = false;
        for(int[] dir: dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1){
                continue;
            }
            q.add(new int[]{nr, nc});
            grid[nr][nc] = 2;
            freshFruitFound = true;
        }
        return freshFruitFound;
    }
}
