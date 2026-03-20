import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp;
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] car = new int[n+1];
        for(int i = 1; i <= n; i++){
            car[i] = Integer.parseInt(st.nextToken());
        }

        int count = Integer.parseInt(br.readLine());

        sum = new int[n+1];
        dp = new int[4][n+1];

        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + car[i];
        }

        for(int i = 1; i < 4; i++){
            for(int j = i * count; j <= n; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-count] + sum[j] - sum[j-count]);
            }
        }

        System.out.println(dp[3][n]);
    }

}
