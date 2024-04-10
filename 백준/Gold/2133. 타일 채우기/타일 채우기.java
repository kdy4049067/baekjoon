import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] dp = new int[31];
        if(n % 2 == 1)
        {
            System.out.println(0);
            return;
        }
        dp[0] = 1;

        for(int i = 2; i <= n; i += 2){
            dp[i] = dp[i-2] * 3;
            for(int j = i - 4; j >= 0; j = j - 2){
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}