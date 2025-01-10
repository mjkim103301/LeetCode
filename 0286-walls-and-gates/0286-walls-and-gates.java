class Solution {
    private List<int[]> gates;
    private Queue<int[]> queue;
    private boolean[][] visit;
    private int[][] move = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };

    public void wallsAndGates(int[][] rooms) {
        // 방을 모두 순회하면서 게이트를 gate map에 담기.
        fillGateMap(rooms);
        // for (int[] i : gates) {
        //     System.out.println(i[0] + " " + i[1]);
        // }
        // gate map을 bfs로 순회하면서 근처의 모든 갈 수 있는 빈 칸의 거리를 채우기
        fillDistanceFromGate(rooms);

    }

    private void fillGateMap(int[][] rooms) {
        gates = new ArrayList<>();
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[0].length; x++) {
                if (rooms[y][x] == 0) {
                    gates.add(new int[] { y, x });
                }
            }
        }
    }

    private void fillDistanceFromGate(int[][] rooms) {
        for (int[] gate : gates) {
            visit = new boolean[rooms.length][rooms[0].length];
            visit[gate[0]][gate[1]]=true;

            queue = new LinkedList<>();
            queue.add(new int[]{gate[0], gate[1], 0}); // y, x, level
            bfs(rooms);
        }
    }

    private void bfs( int[][] rooms) {
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0;i<4;i++){
                int newY = now[0]+move[i][0];
                int newX = now[1]+move[i][1];
                if(newY<0 || newX<0 || newY>=rooms.length || newX>=rooms[0].length){
                    continue;
                }
                if(rooms[newY][newX]<=0 || visit[newY][newX]) continue;
                rooms[newY][newX] = Math.min(rooms[newY][newX], now[2]+1);
                queue.add(new int[]{newY, newX, now[2]+1});
                visit[newY][newX]=true;
            }
        }
    }
}