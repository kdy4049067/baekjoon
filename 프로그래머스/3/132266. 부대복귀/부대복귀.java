import java.util.*;

class Solution {
    
    private static int[] dp;
    private static List<Integer>[] roadList;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = new int[sources.length];
        roadList = new List[n+1];
        dp = new int[n+1];
        
        Queue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        for(int i = 0; i <= n; i++){
            roadList[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int[] roadArr : roads){
            int start = roadArr[0];
            int end = roadArr[1];
            
            roadList[start].add(end);
            roadList[end].add(start);
        }
        
        dp[destination] = 0;
        pq.add(new int[]{destination, 0});
        
        while(!pq.isEmpty()){
            int[] road = pq.poll();
            
            int roadStart = road[0];
            int roadEnd = road[1];
            
            if(dp[roadStart] < roadEnd) continue;
            
            for(int r : roadList[roadStart]){
                if(dp[r] > dp[roadStart] + 1){
                    dp[r] = dp[roadStart] + 1;
                    pq.add(new int[]{r, dp[roadStart] + 1});
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            if(dp[sources[i]] == Integer.MAX_VALUE){ answer[i] = -1;
            continue;
            }   
            answer[i] = dp[sources[i]];
        }
        
        return answer;
    }
}