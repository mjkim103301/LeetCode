class Solution {
    private Map<Integer, PriorityQueue<Integer>> map;
    public int[][] highFive(int[][] items) {
        map = new HashMap<>();
        // map 세팅
        setMap(items);
        // 평균 구하기
        int [][]average = makeAverage();
        // 결과 반환하기
        Arrays.sort(average, (o1, o2)->{return o1[0]-o2[0];});
        return average;
    }

    private void setMap(int[][] items){
        for(int[] item: items){
            int key = item[0];
            int value = item[1];
            if(!map.containsKey(key)){
                map.put(key, new PriorityQueue<>(Collections.reverseOrder()));
            }
            map.get(key).offer(value);
        }
        //System.out.println(map);
    }

    private int[][] makeAverage(){
        int[][] average = new int[map.size()][2];
        int index=0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()){
            Integer key = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            int scoreSum = 0;
            for(int top=0;top<5;top++){
                scoreSum+=value.poll();
            }
            average[index][0] = key;
            average[index++][1] = scoreSum/5;
        }
        return average;
    }
}