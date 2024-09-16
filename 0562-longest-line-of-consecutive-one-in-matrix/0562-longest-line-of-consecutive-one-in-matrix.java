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
    public int[][] move = {
            { 0, -1 },
            { -1, 0 },
            { -1, -1 },
            { -1, 1 }
    };

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
                dp[y][x].horizontal = getHorizontal(y, x, mat[y][x]);
                dp[y][x].vertical = getVertical(y, x, mat[y][x]);
                dp[y][x].diagonal = getDiagonal(y, x, mat[y][x]);
                dp[y][x].antiDiagonal = getAntiDiagonal(y, x, mat[y][x]);

                // System.out.print(dp[y][x]);
            }
            // System.out.println();
        }

        return answer;
    }

    public int getHorizontal(int y, int x, int plus) {
        int max = plus;

        int py = y + move[0][0];
        int px = x + move[0][1];
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].horizontal + plus;
            }
        }
        answer = Math.max(answer, max);

        return max;
    }

    public int getVertical(int y, int x, int plus) {
        int max = plus;
        int py = y + move[1][0];
        int px = x + move[1][1];
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].vertical + plus;
            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    public int getDiagonal(int y, int x, int plus) {
        int max = plus;
        int py = y + move[2][0];
        int px = x + move[2][1];
        if (isInMap(py, px)) {
            if (map[py][px] == 1) {
                max = dp[py][px].diagonal + plus;
            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    public int getAntiDiagonal(int y, int x, int plus) {
        int max = plus;
        int py = y + move[3][0];
        int px = x + move[3][1];
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