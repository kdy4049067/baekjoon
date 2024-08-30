import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int dp[][] = new int[k+1][n+1];


            for(int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            for(int j = 1; j <= k; j++)
                dp[j][1] = 1;


            for(int j = 1; j <= k; j++){
                for(int a = 2; a <= n; a++) {
                    dp[j][a] = dp[j-1][a] + dp[j][a-1];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
