import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[]args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());
        dp = new int[kg+1];
        System.out.println(sugar(kg));

    }
    public static int sugar(int kg){
        if(kg == 4 || kg == 7)
            return -1;
        if(kg % 5 == 0) {
            return kg / 5;
        }
        else if(kg % 5 == 2 || kg % 5 == 4)
            return kg / 5 + 2;
        else if(kg % 5 == 1 || kg % 5 == 3)
            return kg / 5 + 1;

        else
            return 0;
    }
}
