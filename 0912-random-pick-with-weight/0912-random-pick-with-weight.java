class Solution {
    public int[] array;
    public int length;

    public Solution(int[] w) {
        length = w.length;
        array = new int[length];
        array[0] = w[0];
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        double target = array[length - 1] * Math.random();
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */