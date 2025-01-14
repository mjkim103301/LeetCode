class Solution {
    private Queue<Integer> queue;

    public int connectSticks(int[] sticks) {
        queue = new PriorityQueue<>();
        int connectCost = 0;
        for(int stick: sticks){
            queue.offer(stick);
        }

        while(!queue.isEmpty()){
            int stick1 = getStick();
            int stick2 = getStick();
            if(stick1 < 0 || stick2 < 0 ){
                break;
            }
            int score = stick1+stick2;
            connectCost += score;
            queue.offer(score);
        }
        return connectCost;
    }

    private int getStick() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }
}