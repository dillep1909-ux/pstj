import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Task8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) return;

        StringTokenizer tokenizer = new StringTokenizer(line);
        if (!tokenizer.hasMoreTokens()) return;

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            line = reader.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = reader.readLine();
            }
            if (line == null) break;

            tokenizer = new StringTokenizer(line);
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        line = reader.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = reader.readLine();
        }

        if (line != null) {
            tokenizer = new StringTokenizer(line);
            int source = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());

            if (hasRoute(graph, source, destination)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean hasRoute(Map<Integer, List<Integer>> graph, int source, int destination) {
        if (source == destination) return true;
        if (!graph.containsKey(source) || !graph.containsKey(destination)) return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return true;
            }

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}