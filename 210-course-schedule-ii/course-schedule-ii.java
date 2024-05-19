class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courseSchedule = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegreeCounts = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            indegreeCounts.put(i, 0);
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegreeCounts.put(prereq[0], indegreeCounts.get(prereq[0]) + 1);
        }

        for(int i = 0; i < numCourses; i++){
            if(indegreeCounts.get(i) == 0){
                queue.add(i);
            }
        }

        if(queue.isEmpty()){
            return new int[0]; 
        }

        int courseNumber = 0;
        while(!queue.isEmpty()){
            int currentCourse = queue.remove();
            courseSchedule[courseNumber] = currentCourse;
            courseNumber++;
            for( int neighbor : graph.get(currentCourse)){
                indegreeCounts.put(neighbor, indegreeCounts.get(neighbor) - 1);
                if(indegreeCounts.get(neighbor) == 0){
                    queue.add(neighbor);
                }
            }
        }

        for (int count : indegreeCounts.values()) {
            if (count != 0) {
                return new int[0];
            }
        }

        return courseSchedule;
    }
}