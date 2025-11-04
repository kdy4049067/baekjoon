import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int jump = Integer.parseInt(br.readLine());
        int[] bridge = new int[jump+1];
        boolean[] visited = new boolean[jump+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= jump; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[jump+1];
        q.add(start);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        visited[start] = true;

        while(!q.isEmpty()){
            int s = q.poll();

            for(int i = s + bridge[s]; i <= jump; i+= bridge[s]){
                dp[i] = Math.min(dp[i], dp[s] + 1);

                if(visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }

            for(int i = s - bridge[s]; i > 0; i -= bridge[s]){
                dp[i] = Math.min(dp[i], dp[s] + 1);

                if(visited[i])continue;
                    q.add(i);
                    visited[i] = true;
            }

        }

        if(dp[end] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        System.out.println(dp[end]);

    }

}
