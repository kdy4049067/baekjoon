import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<List<Integer>> adj;
    static int[][] dp;  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        dp = new int[2][N+1];

        for(int i=0; i<=N; ++i) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1, 0);
        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    static void dfs(int cur, int prev) {
        dp[0][cur] = 0;
        dp[1][cur] = 1;

        List<Integer> nexts = adj.get(cur);
        for(int next : nexts) {
            if(next == prev) continue;

            dfs(next, cur);
            dp[0][cur] += dp[1][next]; 
            dp[1][cur] += Math.min(dp[1][next], dp[0][next]);
        }
    }
}