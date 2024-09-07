import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int time[] = new int[n+2];
        int price[] = new int[n+2];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n+2];
        int max = -1;
        for(int i = 1; i <= n+1; i++){
            if(max < dp[i]){
                max = dp[i];
            }
            int t = time[i];
            int p = price[i];
            if(i+t > n + 1) continue;
            dp[i+t] = Math.max(p + max, dp[i+t]);

        }
        int result = 0;
        for(int i = 1; i <= n+1; i++){
            if(result < dp[i])
                result = dp[i];
        }

        System.out.println(result);
    }
}
