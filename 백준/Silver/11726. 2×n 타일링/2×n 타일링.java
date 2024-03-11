import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int []dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        dp = new int[size+1];
        int result = dynamic(size);
        System.out.println(result);
    }
    public static int dynamic(int n){
        if(n <= 1)
            return 1;
        if (dp[n] == 0) {
            dp[n] = (dynamic(n-1) + dynamic(n-2)) % 10007;
        }
        return dp[n];

    }
}