import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> list;
    private static int[] people;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        people = new int[count+1];
        dp = new int[count+1][2];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= count; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < count+1; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < count+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < count-1; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        int answer = 0;
        answer = Math.max(dfs(1, -1, 0), dfs(1, -1, 1) + people[1]);

        System.out.println(answer);
    }

    private static int dfs(int now, int prev, int flag){
        int len = list.get(now).size();

        if(dp[now][flag] != -1) return dp[now][flag];
        dp[now][flag] = 0;

        for(int i = 0; i < len; i++){
            int next = list.get(now).get(i);
            if(next != prev){
                if(flag == 1){
                    dp[now][flag] += dfs(next, now, 0);
                }
                else{
                    dp[now][flag] += Math.max(dfs(next, now, 1) + people[next], dfs(next, now, 0));
                }
            }
        }

        return dp[now][flag];
    }

}
