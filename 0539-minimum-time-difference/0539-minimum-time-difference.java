class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = timeToMinutes(timePoints);
        return minDifference(minutes);
    }

    public List<Integer> timeToMinutes(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3));
            minutes.add(hour * 60 + minute);
        }
        return minutes;
    }

    public int minDifference(List<Integer> minutes) {
        Collections.sort(minutes);
        int min = minutes.get(minutes.size() - 1) - minutes.get(0);
        min = Math.min(min, 1440 - min);
        for (int i = 1; i < minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i - 1);
            min = Math.min(min, diff);
        }
        return min;
    }
}