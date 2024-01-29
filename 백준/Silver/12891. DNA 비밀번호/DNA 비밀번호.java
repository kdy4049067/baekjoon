import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int check = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] array = new int[4];
        for(int i = 0; i < check; i++){
            if(str.charAt(i) == 'A'){
                array[0]++;
            }
            else if(str.charAt(i) == 'C')
                array[1]++;
            else if(str.charAt(i) == 'G')
                array[2]++;
            else if(str.charAt(i) == 'T')
                array[3]++;
        }

        int result = 0;

        if(array[0] >= a && array[1] >=c && array[2] >= g && array[3] >=t) {
            result++;
        }

        for(int i = 0; i < size - check; i++){
            if(str.charAt(i) == 'A'){
                array[0]--;
            }
            else if(str.charAt(i) == 'C')
                array[1]--;
            else if(str.charAt(i) == 'G')
                array[2]--;
            else if(str.charAt(i) == 'T')
                array[3]--;

            if(str.charAt(i+check) == 'A'){
                array[0]++;
            }
            else if(str.charAt(i+check) == 'C')
                array[1]++;
            else if(str.charAt(i+check) == 'G')
                array[2]++;
            else if(str.charAt(i+check) == 'T')
                array[3]++;

            if(array[0] >= a && array[1] >=c && array[2] >= g && array[3] >=t) result++;
        }

        System.out.println(result);
    }
}