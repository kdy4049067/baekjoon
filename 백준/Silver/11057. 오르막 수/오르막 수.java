import java.util.Scanner;

public class Main {
    static int[][]dp;
    static int size = 0;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        dp = new int[size+1][10];
        for(int i = 0; i <= 9; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i <= size; i++){
            for(int j = 0; j < 10 ;j++){
                for(int k = j; k < 10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        System.out.println(dp[size][0] % 10007);
    }

}