class Leaderboard {
    private Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            map.replace(playerId, map.get(playerId) + score);
        } else {
            map.put(playerId, score);
        }
    }

    public int top(int K) {
        System.out.println(map);
        int sum = 0;
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
        System.out.println(entryList);
        for (int i = 0; i < K; i++) {
            sum += entryList.get(i).getValue();
        }
        return sum;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */