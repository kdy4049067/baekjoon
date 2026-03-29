import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int first = s.nextInt();
        int second = s.nextInt();
        int third = s.nextInt();

        int result = 0;

        if(first == second && second == third){
            result = 10000 + first * 1000;
        }
        else if(first == second){
            result = 1000 + first * 100;
        }
        else if(second == third){
            result = 1000 + second * 100;
        }
        else if(first == third){
            result = 1000 + first * 100;
        }
        else{
            int max = Math.max(first, Math.max(second, third));
            result = max * 100;
        }

        System.out.println(result);
    }
}
