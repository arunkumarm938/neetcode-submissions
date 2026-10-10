class CountSquares {
    int[][] mat;

    public CountSquares() {
        mat = new int[1001][1001];
    }

    public void add(int[] point) {
        mat[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int i = point[0];
        int j = point[1];

        int count = 0;

        for (int k = 1; k <= 1000; k++) {

            // Top-right square
            if (i-k >= 0 && j+k <= 1000) {
                count += mat[i-k][j]
                       * mat[i][j+k]
                       * mat[i-k][j+k];
            }

            // Bottom-right square
            if (i+k <= 1000 && j+k <= 1000) {
                count += mat[i][j+k]
                       * mat[i+k][j+k]
                       * mat[i+k][j];
            }

            // Bottom-left square
            if (i+k <= 1000 && j-k >= 0) {
                count += mat[i+k][j]
                       * mat[i+k][j-k]
                       * mat[i][j-k];
            }

            // Top-left square
            if (i-k >= 0 && j-k >= 0) {
                count += mat[i][j-k]
                       * mat[i-k][j-k]
                       * mat[i-k][j];
            }
        }

        return count;
    }
}