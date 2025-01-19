class Solution {
    private PriorityQueue<Long> pq;
    private Set<Long> set;
    private int[] value = {2,3,5};

    public int nthUglyNumber(int n) {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        Long uglyNumber = 1L;
        pq.add(uglyNumber);
        for (int i = 0; i < n; i++) {
            uglyNumber = pq.poll();
            System.out.println("i: " + i + ": " + uglyNumber);
            for (int j = 0; j < 3; j++) {
                if (set.add(uglyNumber * value[j])) {
                    pq.add(uglyNumber * value[j]);
                }
            }

        }
        return uglyNumber.intValue();
    }
}