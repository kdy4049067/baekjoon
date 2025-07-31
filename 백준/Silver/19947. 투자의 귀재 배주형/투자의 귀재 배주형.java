import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int[] dp;

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);

        int h = s.nextInt();
        int y = s.nextInt();
        dp = new int[y+1];
        dp[0] = h;

        System.out.println(bank(y));
    }

    private static int bank(int year){
        for(int i = 1; i <= year; i++){
            dp[i] = Math.max(dp[i], (int)(dp[i-1] * 0.05 + dp[i-1]));

            if(i >= 3){
                dp[i] = Math.max(dp[i], (int)(dp[i-3] * 0.2 + dp[i-3]));
            }

            if(i >= 5){
                dp[i] = Math.max(dp[i], (int)(dp[i-5] * 0.35 + dp[i-5]));
            }
        }

        return dp[year];
    }

}
