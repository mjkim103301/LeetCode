class Solution {
    private int[][] dydx = {
            { -2, -1 },
            { -1, -2 },
            { -2, 1 },
            { -1, 2 },
            { 1, 2 },
            { 2, 1 },
            { 2, -1 },
            { 1, -2 }
    };

    private class Node {
        int y, x;
        int level;

        public Node(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    private Queue<Node> queue;
    private boolean[][]visit;
    private int visitPadding=300;

    public int minKnightMoves(int x, int y) {
        visit = new boolean[610][610];
        queue = new LinkedList<>();
        Node knight = new Node(0, 0, 0);
        if (knight.y == y && knight.x == x) {
            return knight.level;
        }
        queue.add(knight);
        visit[knight.y+visitPadding][knight.x+visitPadding]=true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < dydx.length; i++) {
                int newY = now.y + dydx[i][0];
                int newX = now.x + dydx[i][1];
                
                if (visit[newY+visitPadding][newX+visitPadding])
                    continue;
                if (newY == y && newX == x) {
                    return now.level + 1;
                }
                queue.add(new Node(newY, newX, now.level + 1));
                visit[newY+visitPadding][newX+visitPadding]=true;
            }
        }
        return 0;
    }
}