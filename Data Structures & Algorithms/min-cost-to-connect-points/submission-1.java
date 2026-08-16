class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // {cost, point}
        pq.offer(new int[]{0, 0});

        boolean[] visited = new boolean[n];

        int totalCost = 0;
        int connected = 0;

        while (connected < n) {

            int[] curr = pq.poll();
            int cost = curr[0];
            int point = curr[1];

            if (visited[point]) {
                continue;
            }

            // Add this point to our MST
            visited[point] = true;
            totalCost += cost;
            connected++;

            // Add all edges from this newly connected point
            for (int next = 0; next < n; next++) {

                if (visited[next]) {
                    continue;
                }

                int distance =
                    Math.abs(points[point][0] - points[next][0]) +
                    Math.abs(points[point][1] - points[next][1]);

                pq.offer(new int[]{distance, next});
            }
        }

        return totalCost;
    }
}