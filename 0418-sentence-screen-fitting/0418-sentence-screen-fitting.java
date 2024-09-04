class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String combined = String.join("-", sentence) + "-";
        int start = 0;
        while (rows-- > 0) {
            start += cols;
            if (combined.charAt(start % combined.length()) == '-') {
                start++;
            } else {
                while (start > 0 && combined.charAt((start - 1) % combined.length()) != '-') {
                    start--;
                }
            }
        }
        return start / combined.length();
    }
}