class Solution {
    private Queue<Integer> queue;

    public int connectSticks(int[] sticks) {
        queue = new PriorityQueue<>();
        int connectCost = 0;
        for (int stick : sticks) {
            queue.offer(stick);
        }

        while (queue.size()>=2) {
            int stick1 = queue.poll();
            int stick2 = queue.poll();
            
            int score = stick1 + stick2;
            connectCost += score;
            queue.offer(score);
        }
        return connectCost;
    }
}