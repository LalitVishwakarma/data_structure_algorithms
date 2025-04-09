package practice;

import java.util.*;

public class EvaluateDivision {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double dfs(String start, String end, Set<String> visit) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visit.add(start);
        for (Map.Entry<String, Double> node : graph.get(start).entrySet()) {
            if (!visit.contains(node.getKey())) {
                double in = dfs(node.getKey(), end, visit);
                if (in != -1.0)
                    return in * node.getValue();
            }
        }
        return -1.0;

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            if (graph.containsKey(a)) {
                graph.get(a).put(b, value);
            } else {
                graph.put(a, new HashMap<>());
                graph.get(a).put(b, value);
            }
            if (graph.containsKey(b)) {
                graph.get(b).put(a, 1 / value);
            } else {
                graph.put(b, new HashMap<>());
                graph.get(b).put(a, 1 / value);

            }
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a","b"));
        equations.add(List.of("b","c"));

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a","c"));
        queries.add(List.of("b","a"));
        queries.add(List.of("a","e"));
        queries.add(List.of("a","a"));
        queries.add(List.of("x","x"));

        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] result = evaluateDivision.calcEquation(equations, values, queries);
        for (double v : result) {
            System.out.println(v);
        }
    }
}
