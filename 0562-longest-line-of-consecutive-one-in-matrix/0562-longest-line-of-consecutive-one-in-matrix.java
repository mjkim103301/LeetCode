class Node {
    int horizontal;
    int vertical;
    int diagonal;
    int antiDiagonal;

    public Node() {
    }

    // @Override
    // public String toString() {
    // return String.format("[%d, %d, %d, %d]", horizontal, vertical, diagonal,
    // antiDiagonal);
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
                dp[y][x].horizontal = getValue(y, x, 0, mat[y][x]);
                dp[y][x].vertical = getValue(y, x, 1, mat[y][x]);
                dp[y][x].diagonal = getValue(y, x, 2, mat[y][x]);
                dp[y][x].antiDiagonal = getValue(y, x, 3, mat[y][x]);

                // System.out.print(dp[y][x]);
            }
            // System.out.println();
        }

        return answer;
    }

    public int getValue(int y, int x, int i, int plus) {
        int max = plus;
        int py = y + move[i][0];
        int px = x + move[i][1];
        if (isInMap(py, px) && map[py][px] == 1) {
            if (i == 0) {
                max = dp[py][px].horizontal + plus;
            } else if (i == 1) {
                max = dp[py][px].vertical + plus;
            } else if (i == 2) {
                max = dp[py][px].diagonal + plus;
            } else {
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