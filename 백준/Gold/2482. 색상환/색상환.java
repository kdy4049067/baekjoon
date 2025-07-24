import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int[][] dp;
    private static final int mod = 1000000003;
    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();
        dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i = 3; i <= n; i++){
            for(int j = 2; j <= (i+1) / 2; j++){
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % mod;
            }
        }

        System.out.println((dp[n-3][k-1] + dp[n-1][k]) % mod);
        
    }
    
}
