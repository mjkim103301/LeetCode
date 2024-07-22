class Solution {
    public int removeElement(int[] nums, int val) {
        int notEqualValCnt = 0;
        int rearrangeIndex = 0;
        for(int i=0;i<nums.length;i++){
            System.out.println("index: "+i);
            if(nums[i]==val){
                continue;
            }
                notEqualValCnt++;
                nums[rearrangeIndex] = nums[i];
                rearrangeIndex++;
        }
        return notEqualValCnt;
    }
}