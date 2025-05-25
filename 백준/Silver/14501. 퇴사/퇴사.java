import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];

        for(int i = 1; i <= n; i++){
            String[] tp = br.readLine().split(" ");
            int t = Integer.parseInt(tp[0]);
            int p = Integer.parseInt(tp[1]);

            if(i + t > n+1) continue;
            for(int j = i + t; j <= n + 1; j++) {
                dp[j] = Math.max(dp[j], dp[i] + p);
            }
        }

        System.out.println(dp[n+1]);
    }

}
