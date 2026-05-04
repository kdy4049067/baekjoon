import java.util.*;

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Integer> degree = new HashMap<>();

    public int[] solution(int[] nodes, int[][] edges) {
        // 그래프 구성 및 차수 계산
        for (int node : nodes) {
            adj.put(node, new ArrayList<>());
            degree.put(node, 0);
        }

        for (int[] edge : edges) {
            if (adj.containsKey(edge[0]) && adj.containsKey(edge[1])) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
                degree.put(edge[0], degree.get(edge[0]) + 1);
                degree.put(edge[1], degree.get(edge[1]) + 1);
            }
        }

        int oddEvenTree = 0;
        int reverseTree = 0;

        for (int node : nodes) {
            if (!visited.contains(node)) {
                // 한 연결 요소 내의 노드들을 탐색
                List<Integer> component = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(node);
                visited.add(node);

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    component.add(curr);
                    for (int next : adj.get(curr)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }

                // 해당 요소 내에서 조건에 맞는 노드 개수 파악
                int matchCount = 0;   // (번호%2 == 차수%2) 인 노드 수
                int reverseCount = 0; // (번호%2 != 차수%2) 인 노드 수

                for (int n : component) {
                    int d = degree.get(n);
                    if (n % 2 == d % 2) {
                        matchCount++;
                    } else {
                        reverseCount++;
                    }
                }

                // 홀짝 노드가 1개면 그 녀석이 루트가 되어 홀짝 트리 형성
                if (matchCount == 1) oddEvenTree++;
                // 역홀짝 노드가 1개면 그 녀석이 루트가 되어 역홀짝 트리 형성
                if (reverseCount == 1) reverseTree++;
            }
        }

        return new int[]{oddEvenTree, reverseTree};
    }
}