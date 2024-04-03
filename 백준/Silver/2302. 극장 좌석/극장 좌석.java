import java.util.Scanner;

public class Main {
    static int[] dp;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int count = s.nextInt();
        int []seat = new int[size+1];
        for(int i = 0; i < count; i++){
            int fix = s.nextInt();
            seat[fix] = fix;
        }
        dp = new int[size+1];
        dp[0] = 1;
        dp[1] = 1;
        dp(size);
        int result = 1;
        for(int i = 1; i <= size; i++){
            int c = 0;
            while(seat[i] == 0){
                c++;
                if(i == size) break;
                i++;
            }
            result *= dp[c];
        }
        System.out.println(result);
    }
    public static int dp(int n){
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = dp(n-1) + dp(n-2);
    }
}