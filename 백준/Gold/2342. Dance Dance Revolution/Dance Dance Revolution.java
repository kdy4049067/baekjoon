import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int[][][] dp;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == j)
                    map[i][j] = 1;
                else if(i == 0){
                    map[i][j] = 2;
                }
                else if(Math.abs(i-j) == 2)
                    map[i][j] = 4;
                else
                    map[i][j] = 3;
            }
        }

        list = new ArrayList<>();
        dp = new int[st.countTokens()][5][5];

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());

            if(number == 0)
                break;

            list.add(number);
        }

        System.out.println(dfs(0, 0, 0));

    }

    private static int dfs(int index, int cur, int next){
        if(index == list.size()) return 0;

        if(dp[index][cur][next] != 0) return dp[index][cur][next];

        int num = list.get(index);
        dp[index][cur][next] = Math.min(dfs(index+1, num, next) + map[cur][num], dfs(index+1, cur, num) + map[next][num]);

        return dp[index][cur][next];
    }

}
