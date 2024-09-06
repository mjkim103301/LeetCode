class Solution {
    public boolean[][] courseMap;
    public boolean[] finished;
    public int[] preCourseCnt;
    public int completionCnt;
    public Queue<Integer> toTake;

    public int minimumSemesters(int n, int[][] relations) {
        courseMap = new boolean[n + 1][n + 1];
        preCourseCnt = new int[n + 1];
        finished = new boolean[n + 1];
        completionCnt = 0;
        toTake = new LinkedList<>();
        int rotate = 0;

        courseMapInit(n, relations);
        while (true) {
            addCourse(n);
            if (toTake.size() == 0 || completionCnt == n) {
                break;
            }
            takeCourse(n);
            rotate++;
        }
        return getAnswer(rotate, completionCnt, n);
    }

    public void courseMapInit(int n, int[][] relations) {
        for (int[] relation : relations) {
            courseMap[relation[1]][relation[0]] = true;
            preCourseCnt[relation[1]]++;
        }
        // printCourseMap();
    }

    public void addCourse(int n) {
        toTake.clear();
        for (int i = 1; i <= n; i++) {
            if (preCourseCnt[i] == 0 && !finished[i]) {
                toTake.add(i);
            }
        }
        // printToTake();
    }

    public void takeCourse(int n) {
        while (!toTake.isEmpty()) {
            int course = toTake.poll();
            completionCnt++;
            finished[course] = true;

            for (int i = 1; i <= n; i++) {
                if (courseMap[i][course]) {
                    courseMap[i][course] = false;
                    preCourseCnt[i]--;
                }
            }

        }
    }

    public int getAnswer(int rotate, int completionCnt, int n) {
        if (completionCnt < n) {
            return -1;
        }
        return rotate;
    }

    public void printCourseMap() {
        for (boolean[] course : courseMap) {
            System.out.println(Arrays.toString(course));
        }
    }

    public void printToTake() {
        System.out.println(toTake);
    }
}