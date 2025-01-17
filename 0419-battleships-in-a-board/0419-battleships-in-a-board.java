class Solution {
    public int[][] move = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'X') {
                    findSet(y, x, board);
                    count++;
                }
            }
        }
        return count;
    }

    public void findSet(int y, int x, char[][] board) {
        board[y][x] = '.';
        for (int i = 0; i < 4; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];
            if (ny < 0 || nx < 0 || ny >= board.length || nx >= board[0].length
                    || board[ny][nx] != 'X') {
                continue;
            }
            findSet(ny, nx, board);
        }
    }
}