import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] house;
    static int n;
    static int[][] dp;
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        house = new int[n+1][n+1];
        dp = new int[n][3];
        st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            house[i][0] = red;
            house[i][1] = green;
            house[i][2] = blue;
        }
        dynamic();
        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.println(result);
    }

    public static void dynamic(){
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][j];
                }
                else if(j == 1){
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][0]) + house[i][j];
                }

            }
        }
    }
}
