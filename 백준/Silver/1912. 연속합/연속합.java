import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        dp[1] = arr[1];
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }
        int result = -10001;
        for(int i = 1; i <= n; i++){
          if(dp[i] > result)
              result = dp[i];
        }

        System.out.println(result);
    }
}
