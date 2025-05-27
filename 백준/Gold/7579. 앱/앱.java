import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] memory = br.readLine().split(" ");
        String[] cost = br.readLine().split(" ");

        int[] memories = Arrays.stream(memory)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] costs = Arrays.stream(cost)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[n][10001];
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int c = costs[i];
            int mem = memories[i];

            for(int j = 0; j <= 10000; j++){
                if(i == 0){
                    if(j >= c) dp[i][j] = mem;
                }
                else{
                    if(j >= c){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c] + mem);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][j] >= m){
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }

}
