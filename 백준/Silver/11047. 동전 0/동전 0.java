import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int spe = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] kind = new int[spe];
        for(int i = 0; i < spe; i++){
            kind[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        int result = spe-1;
        int c = 0;
        while(total != 0){
            if(total >= kind[result]) {
                count += total / kind[result];
                c = total / kind[result];
                total -= c *  kind[result];
            }
            else
                result--;

        }
        System.out.println(count);
    }
}
