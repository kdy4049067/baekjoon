import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] dx = new int[]{0,0,-1,1};
    private static final int[] dy = new int[]{1,-1,0,0};
    private static int[][] map;
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
           String[] size = br.readLine().split(" ");
           for(int j = 0; j < n; j++){
               map[i][j] = Integer.parseInt(size[j]);
           }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    public static int dfs(int x, int y){
        if(dp[x][y] != 0)
            return dp[x][y];

        int current = map[x][y];
        dp[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int move_x = x + dx[i];
            int move_y = y + dy[i];
            if(move_x < 0 || move_x >= n || move_y < 0 || move_y >= n) continue;

            if(current < map[move_x][move_y]){
                dp[x][y] = Math.max(dp[x][y], dfs(move_x, move_y) + 1);
                dfs(move_x, move_y);
            }
        }

        return dp[x][y];
    }

}
