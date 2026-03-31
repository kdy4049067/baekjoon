import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<long[]>> list;
    private static int k;
    private static int n;
    private static long[][] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long[n+1][k+1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long val = Integer.parseInt(st.nextToken());

            list.get(from).add(new long[]{to, val});
            list.get(to).add(new long[]{from, val});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2)->{
            return Long.compare(n1.val, n2.val);
        });

        pq.add(new Node(1, 0, 0));
        dp[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.val > dp[cur.to][cur.cnt])
                continue;

            for (long[] next : list.get(cur.to)) {
                int nextNode = (int) next[0];
                long weight = next[1];

                if (cur.cnt < k && dp[nextNode][cur.cnt + 1] > dp[cur.to][cur.cnt]) {
                    dp[nextNode][cur.cnt + 1] = dp[cur.to][cur.cnt];
                    pq.add(new Node(nextNode, cur.cnt + 1, dp[nextNode][cur.cnt + 1]));
                }

                if (dp[nextNode][cur.cnt] > dp[cur.to][cur.cnt] + weight) {
                    dp[nextNode][cur.cnt] = dp[cur.to][cur.cnt] + weight;
                    pq.add(new Node(nextNode, cur.cnt, dp[nextNode][cur.cnt]));
                }
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            result = Math.min(result, dp[n][i]);
        }

        System.out.println(result);
    }

    static class Node{
        int to;
        int cnt;
        long val;

        public Node(int to, int cnt, long val){
            this.to = to;
            this.cnt = cnt;
            this.val = val;
        }
    }
}
