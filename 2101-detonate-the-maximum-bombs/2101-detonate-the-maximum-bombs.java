import java.util.*;

class Solution {

    private int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, adj, visited);
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            long node_x = bombs[i][0];
            long node_y = bombs[i][1];
            long r = bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long x2 = bombs[j][0], y2 = bombs[j][1];
                long dx = node_x - x2, dy = node_y - y2;
                long dist = dx * dx + dy * dy;

                if (dist <= r * r) {
                    adj.get(i).add(j);
                }
            }
        }

        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonated = Math.max(maxDetonated, dfs(i, adj, visited));
        }

        return maxDetonated;
    }
}
