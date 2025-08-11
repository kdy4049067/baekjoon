import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int start = 1;
        int index = 1;

        while(start < n){
            start += index * 6;
            index++;
        }

        System.out.println(index);
    }

}
