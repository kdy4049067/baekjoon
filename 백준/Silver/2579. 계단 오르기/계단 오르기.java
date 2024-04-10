import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int []array = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            array[i] = s.nextInt();
        }
        if(n == 1){
            System.out.println(array[1]);
            return;
        }
        dp[1] = array[1];
        dp[2] = array[1]+array[2];
        for(int i = 3; i <= n; i++){
                dp[i] = Math.max(array[i] + array[i-1] + dp[i-3], dp[i-2]+array[i]);
        }
        System.out.println(dp[n]);
    }
}