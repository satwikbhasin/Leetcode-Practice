class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courseSchedule = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegreeCounts = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            indegreeCounts[i] = 0;
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegreeCounts[prereq[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegreeCounts[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            return new int[0];
        }

        int courseNumber = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.remove();
            courseSchedule[courseNumber++] = currentCourse;
            for (int neighbor : graph.get(currentCourse)) {
                indegreeCounts[neighbor]--;
                if (indegreeCounts[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return courseNumber == numCourses ? courseSchedule : new int[0];
    }
}