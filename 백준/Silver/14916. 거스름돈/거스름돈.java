import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        System.out.println(dp(price));

    }

    public static int dp(int price) {
        if(price == 1 || price == 3)
            return -1;
        if (price % 5 == 0) {
            return price / 5;
        } else if (price % 5 == 1 || price % 5 == 4) {
            return price / 5 + 2;
        }
        else if (price % 5 == 2)
            return price / 5 + 1;
        else
            return price / 5 + 3;
    }
}
