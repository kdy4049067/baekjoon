import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    private static Integer[][] dp;
    private static int[] bad;
    private static int[] delight;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        bad = new int[n];
        delight = new int[n];
        dp = new Integer[n][101];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            bad[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            delight[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(n-1, 100));
    }

    private static int knapsack(int i, int k){
           if(i < 0) return 0;

           if(dp[i][k] == null) {
               if (bad[i] >= k) {
                   dp[i][k] = knapsack(i - 1, k);
               } else {
                   dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-bad[i]) + delight[i]);
               }
           }

           return dp[i][k];
    }

}
