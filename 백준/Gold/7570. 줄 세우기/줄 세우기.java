import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int child = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] dp = new int[child+1];
        int[] children = new int[child];

        for(int i = 0; i < child; i++){
            children[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int i = 0; i < child; i++){
            int c = children[i];
            dp[c] = dp[c-1] + 1;
            max = Math.max(max, dp[c]);
        }

        System.out.println(child - max);
    }

}
