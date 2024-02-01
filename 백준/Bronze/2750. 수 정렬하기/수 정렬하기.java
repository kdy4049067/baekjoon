import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n];
        for(int i = 0; i < n; i++){
            int next = Integer.parseInt(br.readLine());
            array[i] = next;
        }

        Arrays.sort(array);
        for(int a : array)
            System.out.println(a);
    }
}