class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // {time, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});

        dist[0][0] = grid[0][0];

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int i = current[1];
            int j = current[2];

            if (time > dist[i][j]) {
                continue;
            }

            if (i == n - 1 && j == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n) {
                    continue;
                }

                int newTime = Math.max(time, grid[ni][nj]);

                if (newTime < dist[ni][nj]) {
                    dist[ni][nj] = newTime;
                    pq.offer(new int[]{newTime, ni, nj});
                }
            }
        }

        return -1;
    }
}