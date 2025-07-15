import java.io.IOException;
import java.util.Scanner;

public class Main {


    private static int mod = 10007;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        System.out.println(dp[n]);
    }
}
