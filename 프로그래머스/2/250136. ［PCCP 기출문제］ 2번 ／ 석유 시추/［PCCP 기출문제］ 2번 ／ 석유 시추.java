import java.util.*;

class Solution {
    int n, m;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int[] oilByColumn; // 각 열에서 얻을 수 있는 총 석유량

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oilByColumn = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 새로운 석유 덩어리 발견 시 딱 한 번만 BFS 실행
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        int answer = 0;
        for (int total : oilByColumn) {
            answer = Math.max(answer, total);
        }
        return answer;
    }

    private void bfs(int x, int y, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;
        // 이 덩어리가 포함된 열 번호들을 중복 없이 저장
        Set<Integer> columns = new HashSet<>();

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            
            count++;
            columns.add(py);

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 덩어리 탐색이 끝나면, 이 덩어리가 걸쳐 있는 모든 열에 크기를 더해줌
        for (int col : columns) {
            oilByColumn[col] += count;
        }
    }
}