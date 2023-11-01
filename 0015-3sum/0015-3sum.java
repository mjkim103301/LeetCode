class Solution {
    public List<List<Integer>> answer=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            twoPointer(i, nums);
        }
        return answer;
    }

    public void twoPointer(int level, int[] nums){
        if(level>0 && nums[level]==nums[level-1]){
            return;
        }
        int left = level+1;
        int right = nums.length-1;

        while(left<right){
            int sum = nums[level] + nums[left] + nums[right];
            if(sum == 0){
                answer.add(new ArrayList<>(List.of(nums[level], nums[left], nums[right])));
                left++;
                right--;
                while(left<right && nums[left] == nums[left-1]){
                    left++;
                }
            }else if(sum>0){
                right--;
            }else {
                left++;
            }
        }
    }
}