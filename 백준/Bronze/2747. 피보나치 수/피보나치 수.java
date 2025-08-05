import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] fibo = new int[n+1];

        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[n]);
    }

}
