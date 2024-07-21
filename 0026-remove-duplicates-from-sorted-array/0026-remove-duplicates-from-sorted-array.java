class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        List<Integer> answerList = new ArrayList<>(set);
        Collections.sort(answerList);
    
        for(int i=0;i<answerList.size();i++){
            nums[i]=answerList.get(i);
        }
        
        return set.size();
        
    }
}