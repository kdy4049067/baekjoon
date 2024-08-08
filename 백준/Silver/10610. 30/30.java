import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        char[] c = n.toCharArray();
        int[] num = new int[c.length];
        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < c.length; i++){
            num[i] = c[i] - '0';
            if(num[i] == 0){
                check = true;
            }
        }

        int add = 0;
        Arrays.sort(num);

        for(int i = c.length-1; i >= 0; i--){
            add += num[i];
            sb.append(num[i]);
        }

        if(add % 3 != 0 || !check){
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());


    }
}
