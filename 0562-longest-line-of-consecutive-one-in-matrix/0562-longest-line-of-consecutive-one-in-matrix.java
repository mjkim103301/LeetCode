class Node {
    int horizontal;
    int vertical;
    int diagonal;
    int antiDiagonal;

    public Node() {
    }

    // @Override
    // public String toString() {
    //     return String.format("[%d, %d, %d, %d]", horizontal, vertical, diagonal, antiDiagonal);
    // }
}

class Solution {
    public Node[][] dp;
    public int[][] map;
    public int answer;

    public int longestLine(int[][] mat) {
        dp = new Node[mat.length][mat[0].length];
        map = new int[mat.length][mat[0].length];
        answer = 0;
        for (int y = 0; y < mat.length; y++) {
            map[y] = Arrays.copyOf(mat[y], mat[0].length);
        }

        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                dp[y][x] = new Node();
                if (map[y][x] == 0)
                    continue;
                dp[y][x].horizontal = getHorizontal(y, x-1, mat[y][x]);
                dp[y][x].vertical = getVertical(y-1, x, mat[y][x]);
                dp[y][x].diagonal = getDiagonal(y-1, x-1, mat[y][x]);
                dp[y][x].antiDiagonal = getAntiDiagonal(y-1, x+1, mat[y][x]);

                // System.out.print(dp[y][x]);
            }
            // System.out.println();
        }

        return answer;
    }

    public int getHorizontal(int py, int px, int plus) {
        int max = plus;
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].horizontal + plus;
            }
        }
        answer = Math.max(answer, max);

        return max;
    }

    public int getVertical(int py, int px, int plus) {
        int max = plus;
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].vertical + plus;
            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    public int getDiagonal(int py, int px, int plus) {
        int max = plus;
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].diagonal + plus;
            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    public int getAntiDiagonal(int py, int px, int plus) {
        int max = plus;
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].antiDiagonal + plus;
            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    public boolean isInMap(int y, int x) {
        if (y < 0 || x < 0 || y >= dp.length || x >= dp[0].length) {
            return false;
        }
        return true;
    }
}