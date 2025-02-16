class Solution {
    private int size = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> answerList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        answerList.add(0);
        set.add(0);
        size = 1<<n;
        solution(n, 0, answerList, set);
        return answerList;
    }

    private boolean solution(int n, int now, List<Integer> answerList, Set<Integer> set){
        if(answerList.size() == size){
            return true;
        }

        for(int i=0;i<n;i++){
            int next = now ^ (1<<i);
            if(set.contains(next)) continue;
            set.add(next);
            answerList.add(next);
            if(solution(n, next, answerList, set)){
                return true;
            }
            set.remove(next);
            answerList.remove(answerList.size()-1);
        }
        return false;
    }
}