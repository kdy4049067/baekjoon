import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    static long[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in)) ;
        int result = Integer.parseInt(br.readLine());
        dp = new long[result+1];

        System.out.println(dynamic(result));
    }

    public static long dynamic(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] > 0) return dp[n];
        dp[n] = dynamic(n-1) + dynamic(n-2);
        return dp[n];
    }
}