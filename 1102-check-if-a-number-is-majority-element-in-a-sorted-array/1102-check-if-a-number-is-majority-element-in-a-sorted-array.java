class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int left = getLeftTargetIndex(nums, target);
        int right = getRightTargetIndex(nums, target);
        int majority = nums.length / 2;
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        System.out.println("majority: " + majority);
        if (left == right) {
            if (nums[0] == target) {
                return true;
            } else {
                return false;
            }
        }
        if (right - left + 1 > majority) {
            return true;
        }
        return false;
    }

    public int getLeftTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return index;
    }

    public int getRightTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return index;
    }
}