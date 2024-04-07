import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int [] arr = new int[size+1];
        for(int i = 1; i <= size; i++){
            arr[i] = s.nextInt();
        }

        int dp[] = new int[size+1];
        dp[1] = arr[1];
        if(size != 1)
            dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= size; i++){
            dp[i] = Math.max(dp[i-2] + arr[i], Math.max(dp[i-3] + arr[i] + arr[i-1],dp[i-1]));
        }
        int max = 0;
        max = dp[size];
        System.out.println(max);
    }
}
