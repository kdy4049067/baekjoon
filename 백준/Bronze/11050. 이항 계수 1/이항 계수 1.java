import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int num = factorial(n);
        int div1 = factorial(k);
        int div2 = factorial(n-k);

        System.out.println(num / div1/ div2);

    }

    public static int factorial(int n){
        if(n == 0)
            return 1;
        return factorial(n-1) * n;
    }
}
