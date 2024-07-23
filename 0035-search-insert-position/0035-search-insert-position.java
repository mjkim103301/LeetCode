class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                break;
            } else if (nums[mid] > target) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[nums.length-1]<target) {
            answer = nums.length;
        }

        return answer;
    }
}