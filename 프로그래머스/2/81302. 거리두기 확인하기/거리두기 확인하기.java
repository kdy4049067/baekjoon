import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];
            boolean check = true;

            for (int j = 0; j < 5 && check; j++) {
                for (int k = 0; k < 5 && check; k++) {
                    if (p[j].charAt(k) == 'P') {
                        if (!bfs(j, k, p)) {
                            check = false;
                        }
                    }
                }
            }

            answer[i] = check ? 1 : 0;
        }
        return answer;
    }

    private static boolean bfs(int r, int c, String[] p) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int rr = pos[0] + dr[i];
                int cc = pos[1] + dc[i];
                if (rr < 0 || cc < 0 || rr >= 5 || cc >= 5 || (rr == r && cc == c)) continue;
                int distance = Math.abs(rr - r) + Math.abs(cc - c);

                if (p[rr].charAt(cc) == 'P' && distance <= 2) {
                    return false;
                } else if (p[rr].charAt(cc) == 'O' && distance < 2) {
                    q.add(new int[]{rr, cc});
                }
            }
        }

        return true;
    }

}
