import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] right = new int[]{0, 1};
    private static final int[] down = new int[]{1, 0};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());

        int start = 1;
        int[][] map = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                map[i][j] = start++;
            }
        }

        int blockX = (block-1) / m + 1;
        int blockY = (block-1) % m + 1;

        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;

        if(block == 0){
            blockX = n;
            blockY = m;
        }

        for(int i = 1; i <= blockX; i++){
            for(int j = 1; j <= blockY; j++){
                if(i == 1 && j == 1) continue;

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        if(block == 0){
            System.out.println(dp[n][m]);
            return;
        }

        for(int i = blockX; i <= n; i++){
            for(int j = blockY; j <= m; j++){
                if(i == blockX & j == blockY) continue;

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[n][m]);
    }

}
