class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24 * 60];
        for (String timePoint : timePoints) {
            int hour = Integer.parseInt(timePoint.substring(0, 2));
            int minute = Integer.parseInt(timePoint.substring(3));
            int time = hour * 60 + minute;
      
            if (times[time]) {
                return 0;
            }
            times[time] = true;
        }

        return minDifference(times);
    }

    public int minDifference(boolean[] times) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (!times[i])
                continue;

            if (left == Integer.MAX_VALUE) {
                left = i;
                right = i;
            } else {
                min = Math.min(i - right, min);
                right = i;
            }
          

        }
        return Math.min(min, 1440 - (right - left));

    }
}