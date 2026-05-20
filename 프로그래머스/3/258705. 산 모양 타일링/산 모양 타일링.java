class Solution {
    public int solution(int n, int[] tops) {
        // 원래 작성하신 dp 배열 크기 그대로 사용
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        // n=1일 때 초기화
        if (tops[0] == 1) {
            dp[1] = 4;
        } else {
            dp[1] = 3;
        }
        
        // i=2부터 n까지 루프
        for (int i = 2; i <= n; i++) {
            if (tops[i - 1] == 1) {
                // 산이 있으면 4배를 한 뒤, 침범으로 손해 본 dp[i-2]를 뺍니다.
                // 자바에서 뺄셈 시 음수가 되는 것을 방지하기 위해 +10007을 더해줍니다.
                dp[i] = (dp[i - 1] * 4 - dp[i - 2] + 10007) % 10007;  
            } else {
                // 산이 없으면 3배를 한 뒤, 침범으로 손해 본 dp[i-2]를 뺍니다.
                dp[i] = (dp[i - 1] * 3 - dp[i - 2] + 10007) % 10007;
            }
        }
        
        return dp[n];
    }
}