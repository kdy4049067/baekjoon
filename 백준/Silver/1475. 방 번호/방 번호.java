import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] num = new int[10];

        String str = String.valueOf(n);

        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - '0';
            num[index]++;
        }

        int max = 0;
        int plus = 0;
        
        for(int i = 0; i < 10; i++){
            if(i == 6 || i == 9){
                plus += num[i];
            }
            else
                max = Math.max(max, num[i]);
        }
        
        max = Math.max(max, (plus+1) / 2);

        System.out.println(max);
    }

}
