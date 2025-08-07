import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] dp = new int[n+4];

        dp[1] = 1;
        dp[3] = 1;

        for(int i = 0; i <= n; i++){
            if(dp[n] == 1){
                System.out.println("SK");
                return;
            }
            else if(dp[n] == 2){
                System.out.println("CY");
                return;
            }
            if(dp[i] == 1){
                dp[i+1] = 2;
                dp[i+3] = 2;
            }

            if(dp[i] == 2){
                dp[i+1] = 1;
                dp[i+3] = 1;
            }
        }
    }

}
