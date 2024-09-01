import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] v = new int[num+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i++){
            v[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[num+1][end+1];

        dp[0][start] = 1;

        for(int i = 1; i <= num; i++){
            for(int j = 0; j <= end; j++){
                if(dp[i-1][j] == 1) {
                    int add = j + v[i];
                    int sub = j - v[i];

                    if(add <= end) dp[i][add] = 1;
                    if(sub >= 0) dp[i][sub] = 1;
                }

            }
        }
        int res = -1;
        for(int i = end; i >= 0; i--){
            if(dp[num][i] == 1){
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
