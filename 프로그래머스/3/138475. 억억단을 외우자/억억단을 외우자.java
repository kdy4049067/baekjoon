import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dp = new int[e+1];
        int[] maxDp = new int[e+1];

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                dp[j]++;
            }
        }
        
        maxDp[e] = e;
        
        for(int i = e-1; i >= 1; i--){
            if(dp[i] >= dp[maxDp[i+1]]) maxDp[i] = i;
            else maxDp[i] = maxDp[i+1];
        }

        for(int i = 0; i < starts.length; i++){
            int s = starts[i];
            
            answer[i] = maxDp[s];
        }
        
        return answer;
    }
}