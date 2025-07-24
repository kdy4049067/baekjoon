import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] warrior;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        warrior = new int[n];
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            warrior[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--){
            dfs(i);
        }

        int max = dp[0];

        for(int i = 1; i < n; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }

    private static int dfs(int index){
        if(dp[index] == null) {
            dp[index] = 1;

            for (int i = index - 1; i >= 0; i--) {
                if (warrior[index] < warrior[i]) {
                    dp[index] = Math.max(dfs(i) + 1, dp[index]);
                }
            }

        }
        return dp[index];
    }

}
