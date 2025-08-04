import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        int[] dp = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + card[j-1]);
            }
        }

        System.out.println(dp[n]);
    }

}
