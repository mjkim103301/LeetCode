class Solution {
    public boolean isPalindrome(int x) {
        String reverseValue = reverse(x);
        if(reverseValue.equals(x+"")){
            return true;
        }
        return false;
        
    }

    public String reverse(int x){
        StringBuilder sb = new StringBuilder(x+"");
        return sb.reverse().toString();
    }
}