import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] left = new int[n];
        int[] right = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) left[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) right[i] = Integer.parseInt(st.nextToken());

        // 1. DP 테이블 초기화: -1은 아직 도달하지 못한 상태를 의미
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 시작점: 왼쪽 0개, 오른쪽 0개 버린 상태의 점수는 0점
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 2. 도달할 수 없는 상태라면 계산 건너뛰기
                if (dp[i][j] == -1) continue;

                // 상황 A: 왼쪽 카드만 버리거나, 둘 다 버리기 (점수 획득 X)
                // 다음 상태인 dp[i+1][j]와 dp[i+1][j+1]에 현재 점수 전달
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);

                // 상황 B: 왼쪽 카드가 오른쪽 카드보다 클 때 (오른쪽 카드 버리고 점수 획득)
                if (left[i] > right[j]) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + right[j]);
                }
            }
        }

        // 3. 결과 찾기: 왼쪽이나 오른쪽 중 어느 한쪽이라도 카드를 다 쓴(n) 상태들 중 최댓값
        int ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[n][k], dp[k][n]));
        }

        System.out.println(ans);
    }
}