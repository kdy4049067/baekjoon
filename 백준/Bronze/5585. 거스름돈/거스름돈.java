import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        int buy = s.nextInt();

        int target = 1000 - buy;
        int result = 0;

        while(true){
            if(target / 500 >= 1){
                int count = target / 500;
                result += count;
                target -= count * 500;
            }
            else if(target / 100 >= 1){
                int count = target / 100;
                result += count;
                target -= count * 100;
            }
            else if(target / 50 >= 1){
                int count = target / 50;
                result += count;
                target -= count * 50;
            }
            else if(target / 10 >= 1){
                int count = target / 10;
                result += count;
                target -= count * 10;
            }
            else if(target / 5 >= 1){
                int count = target / 5;
                result += count;
                target -= count * 5;
            }
            else{
                int count = target;
                result += count;
                target -= count;
            }

            if(target == 0) break;
        }

        System.out.println(result);
    }

}
