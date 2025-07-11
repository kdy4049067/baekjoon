import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] intArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        intArray = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            dfs(i);
        }

        int max = dp[0];

        for(int i = 1; i < n; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    public static int dfs(int index){
        if(dp[index] == null){
            dp[index] = 1;

            for(int i = index-1; i >= 0; i--){
                if(intArray[i] < intArray[index]){
                    dp[index] = Math.max(dp[index], dfs(i) + 1);
                }
            }
        }

        return dp[index];
    }

}
