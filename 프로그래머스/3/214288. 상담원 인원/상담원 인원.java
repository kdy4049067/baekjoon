import java.util.*;

class Solution {
    
    private int answer = Integer.MAX_VALUE;
    // baseWaitTime[i][j] : i번 유형의 상담에 j명의 상담원을 배치했을 때의 총 대기시간
    private int[][] baseWaitTime; 

    public int solution(int k, int n, int[][] reqs) {
        // 1. 상담 유형별로 요청들을 분리하여 담을 리스트 초기화 (1~k번 유형 사용)
        ArrayList<int[]>[] requestsByType = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            requestsByType[i] = new ArrayList<>();
        }

        for (int[] req : reqs) {
            int start = req[0];
            int duration = req[1];
            int type = req[2];
            requestsByType[type].add(new int[]{start, duration});
        }

        // 2. 각 유형별, 상담원 인원수별 대기 시간을 미리 계산
        // 인원은 최대 n - k + 1 명까지 배치될 수 있습니다.
        baseWaitTime = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                baseWaitTime[i][j] = getWaitingTime(requestsByType[i], j);
            }
        }

        // 3. DFS를 돌며 각 유형에 상담원을 배치하는 모든 조합을 구함
        int[] chosenCounts = new int[k + 1];
        dfs(1, n, k, chosenCounts);

        return answer;
    }

    // 특정 유형에 할당된 상담원 수가 consultantCount 일 때의 대기 시간을 시뮬레이션하는 함수
    private int getWaitingTime(ArrayList<int[]> requests, int consultantCount) {
        if (requests.isEmpty()) return 0;

        // 상담원들의 '상담이 끝나는 시간'을 관리하는 우선순위 큐 (오름차순 정렬)
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        // 처음에는 모든 상담원이 0초에 업무가 끝나는 상태로 초기화
        for (int i = 0; i < consultantCount; i++) {
            endTimes.add(0);
        }

        int totalWaitTime = 0;

        for (int[] req : requests) {
            int startTime = req[0];
            int duration = req[1];

            // 가장 빨리 끝나는 상담원의 종료 시간을 꺼냄
            int earliestEndTime = endTimes.poll();

            if (startTime < earliestEndTime) {
                // 손님이 상담원 종료 시간보다 일찍 왔다면 대기 발생
                totalWaitTime += (earliestEndTime - startTime);
                // 상담이 끝난 직후 바로 이어서 다음 상담 시작
                endTimes.add(earliestEndTime + duration);
            } else {
                // 상담원이 이미 놀고 있었다면 대기 없이 즉시 시작
                endTimes.add(startTime + duration);
            }
        }

        return totalWaitTime;
    }

    // 중복 조합 DFS (1번 유형부터 k번 유형까지 인원 배분)
    private void dfs(int type, int remainCount, int k, int[] chosenCounts) {
        // 마지막 유형까지 인원을 모두 배정했을 때
        if (type == k) {
            chosenCounts[type] = remainCount; // 남은 인원 전부 마지막 유형에 배정
            
            // 모든 유형의 대기 시간 합산
            int currentSum = 0;
            for (int i = 1; i <= k; i++) {
                currentSum += baseWaitTime[i][chosenCounts[i]];
            }
            
            // 최소 대기 시간 갱신
            answer = Math.min(answer, currentSum);
            return;
        }

        // 현재 유형에 배치할 수 있는 인원 (최소 1명 ~ 남은 인원 중 다른 유형들이 1명씩은 가져갈 만큼만)
        for (int i = 1; i <= remainCount - (k - type); i++) {
            chosenCounts[type] = i;
            dfs(type + 1, remainCount - i, k, chosenCounts);
        }
    }
}