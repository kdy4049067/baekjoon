import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dp;
    private static int[] plan;
    private static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        day = Integer.parseInt(st.nextToken());
        int ban = Integer.parseInt(st.nextToken());

        plan = new int[day+1];

        if(ban>0) {
            st = new StringTokenizer(br.readLine());

            for(int i=1; i<=ban; i++) {
                plan[Integer.parseInt(st.nextToken())] = 1;
            }
        }

        dp = new int[day+1][day+1];
        for(int i=0; i<day+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(1, 0));
    }

    private static int recur(int index, int coupon) {
        if(index > day) return 0;

        if(dp[index][coupon] != -1) return dp[index][coupon];

        dp[index][coupon] = Integer.MAX_VALUE;

        if (plan[index] == 1) {
            dp[index][coupon] = Math.min(dp[index][coupon], recur(index + 1, coupon));
        } else {
            if((coupon >= 3)) {
                dp[index][coupon] = Math.min(dp[index][coupon], recur(index + 1, coupon - 3));
            }
            dp[index][coupon] = Math.min(dp[index][coupon], recur(index+1, coupon) + 10000);
            dp[index][coupon] = Math.min(dp[index][coupon], recur(index+3, coupon+1) + 25000);
            dp[index][coupon] = Math.min(dp[index][coupon], recur(index+5, coupon+2) + 37000);
        }

        return dp[index][coupon];
    }

}
