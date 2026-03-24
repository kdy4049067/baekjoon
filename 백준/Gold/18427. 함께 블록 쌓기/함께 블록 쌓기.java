import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int student = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] info = new int[student+1][count+1];
        int[][] dp = new int[student+1][height+1];

        for(int i = 1; i <= student; i++){
            st = new StringTokenizer(br.readLine());
            int index = 1;
            while(st.hasMoreTokens()){
                info[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= student; i++){
            for(int j = 1; j <= count; j++){
                for(int k = 1; k <= height; k++){
                    if(info[i][j] == 0){
                        break;
                    }
                    if(dp[i][k] < dp[i-1][k])
                        dp[i][k] = dp[i-1][k];
                    if(info[i][j] == k){
                        dp[i][k] += 1 % 10007;
                    }
                    if(info[i][j] < k) {
                        dp[i][k] += dp[i - 1][k - info[i][j]] % 10007;
                    }
                }
            }
        }

        System.out.println(dp[student][height] % 10007);
    }

}
