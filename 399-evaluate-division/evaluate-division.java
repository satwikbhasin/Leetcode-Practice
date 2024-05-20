// class Solution {
//     private double dfs(Map<String, HashMap<String, Double>> graph, String source, String target, double productTillNow,
//             HashSet<String> visited) {
//         double ans = -1.0;

//         Map<String, Double> neighbors = graph.get(source);
//         if (neighbors.containsKey(target))
//             ans = productTillNow * neighbors.get(target);
//         else {
//             for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
//                 String neighborName = neighbor.getKey();
//                 Double neighborValue = neighbor.getValue();
//                 if (!visited.contains(neighborName)) {
//                     visited.add(neighborName);
//                     ans = dfs(graph, neighborName, target, productTillNow * neighborValue, visited);
//                     if (ans == -1.0) {
//                         break;
//                     }
//                     visited.remove(neighborName);
//                 }
//             }
//         }

//         return ans;
//     }

//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         Map<String, HashMap<String, Double>> graph = new HashMap<>();
//         for (int i = 0; i < equations.size(); i++) {
//             List<String> equation = equations.get(i);
//             String dividend = equation.get(0);
//             String divisor = equation.get(1);
//             double quotient = values[i];

//             if (!graph.containsKey(dividend)) {
//                 graph.put(dividend, new HashMap<String, Double>());
//             }
//             if (!graph.containsKey(divisor)) {
//                 graph.put(divisor, new HashMap<String, Double>());
//             }

//             graph.get(dividend).put(divisor, quotient);
//             graph.get(divisor).put(dividend, 1 / quotient);
//         }

//         double[] results = new double[queries.size()];
//         for (int i = 0; i < queries.size(); i++) {
//             List<String> query = queries.get(i);
//             String source = query.get(0);
//             String target = query.get(1);

//             if (!graph.containsKey(source) || !graph.containsKey(target))
//                 results[i] = -1.0;
//             else if (source.equals(target))
//                 results[i] = 1.0;
//             else {
//                 HashSet<String> visited = new HashSet<String>();
//                 visited.add(source);
//                 results[i] = dfs(graph, source, target, 1.0, visited);
//             }
//         }

//         return results;
//     }
// }

import java.util.*;

class Solution {
    private double dfs(Map<String, HashMap<String, Double>> graph, String source, String target, double productTillNow,
                       HashSet<String> visited) {
        double ans = -1.0;

        Map<String, Double> neighbors = graph.get(source);
        if (neighbors.containsKey(target)) {
            ans = productTillNow * neighbors.get(target);
        } else {
            for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
                String neighborName = neighbor.getKey();
                Double neighborValue = neighbor.getValue();
                if (!visited.contains(neighborName)) {
                    visited.add(neighborName);
                    ans = dfs(graph, neighborName, target, productTillNow * neighborValue, visited);
                    if (ans != -1.0) {
                        break;
                    }
                    visited.remove(neighborName);
                }
            }
        }

        return ans;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];

            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<>());
            }

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String source = query.get(0);
            String target = query.get(1);

            if (!graph.containsKey(source) || !graph.containsKey(target)) {
                results[i] = -1.0;
            } else if (source.equals(target)) {
                results[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                visited.add(source);
                results[i] = dfs(graph, source, target, 1.0, visited);
            }
        }

        return results;
    }
}
