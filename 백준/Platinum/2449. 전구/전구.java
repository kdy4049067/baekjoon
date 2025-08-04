import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    private static int[][] dp;
    private static int[] light;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        light = new int[n];
        dp = new int[n][n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(solve(0, n-1));

    }

    private static int solve(int start, int end){
        if(dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
        if(start == end) return 0;

        for(int i = start; i < end; i++){
            int cnt = 0;
            if(light[start] != light[i+1]) cnt = 1;

            dp[start][end] = Math.min(dp[start][end], solve(start, i) + solve(i+1, end) + cnt);
        }

        return dp[start][end];
    }

}
