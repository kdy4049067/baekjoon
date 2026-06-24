import java.util.*;  

class Solution{
    public int solution(int alp, int cop, int[][] problems) {
      int maxA = 0, maxC = 0;
      for(int[] p : problems) {
          maxA = Math.max(maxA, p[0]);
          maxC = Math.max(maxC, p[1]);
      }

      alp = Math.min(alp, maxA);
      cop = Math.min(cop, maxC);
  
      int[][] dp = new int[maxA+1][maxC+1];
      for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
      dp[alp][cop] = 0;

      for(int i = alp; i <= maxA; i++) {
          for(int j = cop; j <= maxC; j++) {
              if(dp[i][j] == Integer.MAX_VALUE) continue;

              if(i+1 <= maxA) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
              if(j+1 <= maxC) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

              for(int[] p : problems) {
                  if(p[0] <= i && p[1] <= j) {
                      int na = Math.min(i + p[2], maxA);
                      int nc = Math.min(j + p[3], maxC);
                      dp[na][nc] = Math.min(dp[na][nc], dp[i][j] + p[4]);
                  }
              }
          }
      }

      return dp[maxA][maxC];
  }
}
