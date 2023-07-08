package manas.task1;

import java.util.*;

public class TopologicalSort {

    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, graph, visited, stack);
            }
        }

        List<String> sortedMethods = new ArrayList<>(stack);
        Collections.reverse(sortedMethods);
        return sortedMethods;
    }

    private static void dfs(String node, Map<String, List<String>> graph, Set<String> visited, Deque<String> stack) {
        visited.add(node);

        if (graph.containsKey(node)) {
            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, graph, visited, stack);
                }
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<String>> methods = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] methodInfo = scanner.nextLine().split(" ");
            String methodName = methodInfo[0];
            List<String> dependencies = Arrays.asList(methodInfo).subList(2, methodInfo.length);
            methods.put(methodName, dependencies);
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (String method : methods.keySet()) {
            graph.put(method, methods.get(method));
        }

        List<String> sortedMethods = topologicalSort(graph);

        for (String method : sortedMethods) {
            System.out.print(method + " ");
        }
    }
}
