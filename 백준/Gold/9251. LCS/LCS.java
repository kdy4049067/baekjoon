import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static Integer[][] dp;
    static char[] first;
    static char[] second;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();

        dp = new Integer[first.length][second.length];

        System.out.println(dfs(first.length-1, second.length-1));
    }

    private static int dfs(int x, int y){

        if(x == -1 || y == -1){
            return 0;
        }

        if(dp[x][y] == null){
            dp[x][y] = 0;

            if(first[x] == second[y]){
                dp[x][y] = dfs(x-1, y-1) + 1;
            }
            else{
                dp[x][y] = Math.max(dfs(x-1, y), dfs(x, y-1));
            }
        }

        return dp[x][y];
    }

}
