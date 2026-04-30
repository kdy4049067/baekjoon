import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotCount = routes.length;
        
        // 1. 각 로봇의 시간대별 위치를 저장할 리스트 (Queue의 배열)
        // robots[i] 에는 i번 로봇이 시간대별로 밟는 좌표들이 순서대로 들어감
        Queue<int[]>[] robots = new LinkedList[robotCount];
        
        int maxTime = 0;
        for (int i = 0; i < robotCount; i++) {
            robots[i] = new LinkedList<>();
            int[] current = points[routes[i][0] - 1];
            robots[i].add(new int[]{current[0], current[1]}); // 시작점 추가 (0초)
            
            for (int j = 1; j < routes[i].length; j++) {
                int[] next = points[routes[i][j] - 1];
                int curR = current[0];
                int curC = current[1];
                int nextR = next[0];
                int nextC = next[1];
                
                // R 좌표 먼저 이동
                while (curR != nextR) {
                    curR += (nextR > curR) ? 1 : -1;
                    robots[i].add(new int[]{curR, curC});
                }
                // C 좌표 이동
                while (curC != nextC) {
                    curC += (nextC > curC) ? 1 : -1;
                    robots[i].add(new int[]{curR, curC});
                }
                current = next; // 다음 목적지로 갱신
            }
            maxTime = Math.max(maxTime, robots[i].size());
        }

        // 2. 시간대별(0초 ~ 최대시간) 충돌 체크
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < robotCount; i++) {
                // 해당 시간에 로봇이 아직 운행 중이라면
                if (!robots[i].isEmpty()) {
                    int[] pos = robots[i].poll();
                    String key = pos[0] + "," + pos[1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            
            for (int count : map.values()) {
                if (count >= 2) answer++;
            }
        }
        
        return answer;
    }
}