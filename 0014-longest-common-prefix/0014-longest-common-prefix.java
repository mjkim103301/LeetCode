class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minIndex = 0;
        for(int i=1;i<strs.length;i++){
            if(strs[minIndex].length() > strs[i].length()){
                minIndex = i;
            }
        }

        String target = strs[minIndex];
        while(target.length()>0){
            if(findLongestCommonPrefix(target, strs)){
                break;
            }
            target = target.substring(0, target.length()-1);
        }
        return target;
        
    }

    public boolean findLongestCommonPrefix(String target, String[] strs){
        for(String item: strs){
            if(item.indexOf(target)!=0){
                return false;
            }
        }
        return true;
    }
}