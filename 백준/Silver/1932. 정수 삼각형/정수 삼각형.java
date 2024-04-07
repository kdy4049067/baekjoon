import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [][] triangle = new int[size+1][size+1];
        int [][] dp = new int[size+1][size+1];

        for(int i = 1; i <= size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 1;
            while(st.hasMoreTokens()){
                triangle[i][index] = Integer.parseInt(st.nextToken());
                index++;
            }
        }

        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        int max = 0;
        for(int i = 1; i <= size; i++){
            if(max < dp[size][i])
                max = dp[size][i];
        }
        System.out.println(max);


    }
}
