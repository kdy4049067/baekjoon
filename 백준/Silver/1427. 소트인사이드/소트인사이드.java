import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char [] c = str.toCharArray();
        for(int i = 0; i < c.length-1; i++){
            int max_index = i;
            for(int j = i + 1; j < c.length; j++){
                if(c[max_index] < c[j]){
                    max_index = j;
                }
            }
            char max = c[max_index];
            c[max_index] = c[i];
            c[i] = max;
        }
        int [] array = new int[c.length];
        for(int i = 0; i < array.length; i++){
            array[i] = c[i] - '0';
        }
        for(int num : array)
            System.out.print(num);
    }
}