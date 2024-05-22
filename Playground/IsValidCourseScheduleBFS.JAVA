import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class IsValidCourseScheduleBFS {
    public static boolean isValidCourseSchedule(int n, List<List<Integer>> prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> courseOrder = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegreeCount = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
            indegreeCount.put(i, 0);
        }

        for(List<Integer> prerequisite : prerequisites){
            int course = prerequisite.get(0);
            int preCourse = prerequisite.get(1);
            graph.get(preCourse).add(course);
            indegreeCount.put(course, indegreeCount.get(course) + 1);
        }

        for(int i = 0; i < n; i++){
            if(indegreeCount.get(i) == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int currentCourse = queue.remove();
            courseOrder.add(currentCourse);
            for( int neighbor : graph.get(currentCourse)){
                indegreeCount.put(neighbor, indegreeCount.get(neighbor) - 1);
                if(indegreeCount.get(neighbor) == 0){
                    queue.add(neighbor);
                }
            }
        }

        return courseOrder.size() == n;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int prerequisitesLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> prerequisites = new ArrayList<>();
        for (int i = 0; i < prerequisitesLength; i++) {
            prerequisites.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = isValidCourseSchedule(n, prerequisites);
        System.out.println(res);
    }
}
