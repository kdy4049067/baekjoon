import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[size+1];
            int[][] dp = new int[size+1][size+1];
            int[] sum = new int[size+1];

            int result = Integer.MIN_VALUE;

            for(int j = 1; j <= size; j++){
                Arrays.fill(dp[j], Integer.MIN_VALUE);
            }

            for(int j = 1; j <= size; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1] + arr[j];
                dp[j][j] = arr[j];
            }

            for(int j = 1; j <= size; j++){
                for(int k = j; k <= size; k++){
                    int val = sum[k] - sum[j - 1];

                    if(dp[j][k-1] <= val){
                        dp[j][k] = val;
                    }
                    else {
                        dp[j][k] = dp[j][k - 1];
                    }
                    result = Math.max(result, dp[j][k]);
                }
            }

            System.out.println(result);
        }
    }

}
