class Solution {
    public int missingNumber(int[] arr) {
        int standard = Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[arr.length - 1] - arr[arr.length - 2]));
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (standard < diff) {
                if (arr[0] < arr[1]) {
                    return arr[i] - standard;
                } else {
                    return arr[i] + standard;
                }
            }
        }
        return arr[0];
    }
}