import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class isValidCourseScheduleDFS {
    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int currNode, boolean[] currPath){
        if(currPath[currNode]) return false;

        if(visited[currNode]) return true;

        currPath[currNode] = true;
        visited[currNode] = true;

        for(int neighbor : graph.get(currNode)){
            boolean res = dfs(graph, visited, neighbor, currPath);
            if(!res) return false;
        }

        currPath[currNode] = false;
        return true;
    }

    public static boolean isValidCourseSchedule(int n, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(List<Integer> prerequisite : prerequisites){
            int course = prerequisite.get(0);
            int preCourse = prerequisite.get(1);
            graph.get(preCourse).add(course);
        }

        for(int  i = 0; i < n; i++){
            if (!visited[i]) {
                if (!dfs(graph, visited, i, new boolean[n])) {
                    return false;
                }
            }
        }

        return true;
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
