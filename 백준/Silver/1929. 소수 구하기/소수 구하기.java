import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int end;
    static int[] array;
    static boolean[] check;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        check = new boolean[end+1];
        array = new int[end+1];

        Arrays.fill(array,1);
        array[1] = 0;
        sosu(end);

        for(int i = start; i <= end; i++){
            if(array[i] == 1)
                System.out.println(i);
        }
    }

    static void sosu(int start) {
        for (int i = 2; i <= start; i++) {
            if(check[i]) continue;
            if (array[i] == 1) {
                check[i] = true;
                int j = 2;
                while (i * j <= end) {
                    array[i * j] = 0;
                    check[i * j] = true;
                    j++;
                }
            }

        }
    }
}
