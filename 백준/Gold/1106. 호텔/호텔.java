import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());
        int[] dp = new int[people+101];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for(int i = 0; i < city; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());
            for(int j = add; j < people + 101; j++){
                dp[j] = Math.min(dp[j], price + dp[j-add]);
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = people; i <= people + 100; i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);



    }
}
