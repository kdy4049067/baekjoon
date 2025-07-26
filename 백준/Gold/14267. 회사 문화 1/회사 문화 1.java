import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int[] dp;
    private static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[n+1];

        list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int firm = Integer.parseInt(st.nextToken());
            if(i == 0) continue;

            list.get(firm).add(i+1);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dp[index] += weight;
        }

        dfs(1);

        for(int i = 1; i <= n; i++){
            System.out.print(dp[i] + " ");
        }

    }

    private static void dfs(int index){
        for(int i : list.get(index)){
            dp[i] += dp[index];
            dfs(i);
        }
    }

}
