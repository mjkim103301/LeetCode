class Solution {
    private Stack<Integer> openStack, unlockedStack;

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        openStack = new Stack<>();
        unlockedStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlockedStack.push(i);
            } else if (s.charAt(i) == '(') {
                openStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!unlockedStack.isEmpty()) {
                    unlockedStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (openStack.size() > 0 && unlockedStack.size() > 0 && openStack.peek() < unlockedStack.peek()) {
            openStack.pop();
            unlockedStack.pop();
        }

        if (!openStack.empty()) {
            return false;
        }
        return true;
    }
}