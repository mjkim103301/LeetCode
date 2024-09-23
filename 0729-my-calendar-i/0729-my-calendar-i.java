class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevStart = treeMap.floorKey(start);
        Integer nextStart = treeMap.ceilingKey(start);

        if ((prevStart == null || start >= treeMap.get(prevStart)) && (nextStart == null || end <= nextStart)) {
            treeMap.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */