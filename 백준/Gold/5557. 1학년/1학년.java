import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] box;
    private static long[][] dp;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        box = new int[n];
        dp = new long[n][21];

        for(int i = 0; i < n; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][box[0]] = 1;

        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < 21; j++){
                if(dp[i][j] != 0){
                    int cur = j;
                    int val = box[i+1];

                    if(check(cur - val))
                        dp[i+1][cur-val] += dp[i][j];
                    if(check(cur + val))
                        dp[i+1][cur+val] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-2][box[n-1]]);
    }

    private static boolean check(int num){
        return (0 <= num && num <= 20);
    }

}
