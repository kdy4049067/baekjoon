import java.util.*;

class Solution {
    private int[][] dist;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int eX = 0, eY = 0;
    
    private int[] req;       // 각 패널별 선행 조건 비트마스크
    private int[][] dp;      // dp[방문상태비트마스크][마지막패널위치]
    private int K;
    private final int INF = 100000000; // 오버플로우 방지용 무한대 값

    public int solution(int h, String[] grid, int[][] panels, int[][] seqs) {
        K = panels.length;
        dist = new int[K + 1][K + 1];
        req = new int[K];
        dp = new int[1 << K][K];
        
        // DP 배열을 -1로 초기화 (아직 계산 안 됨을 의미)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 탈출구(@) 위치 찾기
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '@') {
                    eX = i; eY = j;
                    break;
                }
            }
        }

        // 1. 모든 패널 간의 최단 거리 계산 (기존 BFS 활용)
        for (int i = 0; i < K - 1; i++) {
            for (int j = i + 1; j < K; j++) {
                int preX = panels[i][1] - 1, preY = panels[i][2] - 1, preH = panels[i][0];
                int nextX = panels[j][1] - 1, nextY = panels[j][2] - 1, nextH = panels[j][0];

                int distance = 0;
                if (preH == nextH) {
                    distance = bfs(grid, preX, preY, nextX, nextY);
                } else {
                    distance = bfs(grid, preX, preY, eX, eY) + bfs(grid, eX, eY, nextX, nextY) + Math.abs(preH - nextH);
                }

                dist[i + 1][j + 1] = distance;
                dist[j + 1][i + 1] = distance;
            }
        }

        // 2. 선행 제약 조건을 비트마스크로 압축 저장 (0-indexed 사용)
        for (int[] seq : seqs) {
            int from = seq[0] - 1;
            int to = seq[1] - 1;
            req[to] |= (1 << from); // to번 패널을 켜려면 from번 비트가 켜져 있어야 함
        }

        // 3. 비트마스킹 DP 호출 
        // 초기 상태: 활성화된 패널 없음(mask = 0), 기술자 시작 위치는 1번 패널(index = 0)
        return memoize(0, 0);
    }

    private int memoize(int mask, int last) {
        // 모든 패널을 다 활성화한 경우 종료 (기저 조건)
        if (mask == (1 << K) - 1) {
            return 0;
        }

        // 이미 계산한 적이 있는 상태라면 그 값을 즉시 반환 (시간 단축의 핵심)
        if (dp[mask][last] != -1) {
            return dp[mask][last];
        }

        int minCost = INF;

        for (int next = 0; next < K; next++) {
            // 이미 활성화한 패널 패스
            if ((mask & (1 << next)) != 0) continue;
            
            // 아직 선행 패널들이 다 켜지지 않았다면 패스
            if ((mask & req[next]) != req[next]) continue;

            // 다음 패널 활성화 상태로 전진
            int nextMask = mask | (1 << next);
            
            // 현재 위치(last)에서 다음 위치(next)까지의 거리 + 남은 패널들의 최소 거리
            int cost = dist[last + 1][next + 1] + memoize(nextMask, next);
            minCost = Math.min(minCost, cost);
        }

        return dp[mask][last] = minCost;
    }

    private int bfs(String[] grid, int curX, int curY, int nextX, int nextY) {
        if (curX == nextX && curY == nextY) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curX, curY, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (p[0] == nextX && p[1] == nextY) {
                return p[2];
            }

            for (int i = 0; i < 4; i++) {
                int moveX = p[0] + dx[i];
                int moveY = p[1] + dy[i];

                if (moveX < 0 || moveX >= grid.length || moveY < 0 || moveY >= grid[0].length()) continue;
                if (grid[moveX].charAt(moveY) == '#' || visited[moveX][moveY]) continue;

                queue.add(new int[]{moveX, moveY, p[2] + 1});
                visited[moveX][moveY] = true;
            }
        }
        return INF;
    }
}