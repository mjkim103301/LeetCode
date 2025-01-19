class Solution {
    private TreeSet<Long> set;

    public int nthUglyNumber(int n) {
        set = new TreeSet<>();
        Long uglyNumber = 1L;
        set.add(uglyNumber);
        for (int i = 0; i < n; i++) {
            uglyNumber = set.pollFirst();
            set.add(uglyNumber * 2);
            set.add(uglyNumber * 3);
            set.add(uglyNumber * 5);
        }
        return uglyNumber.intValue();
    }
}