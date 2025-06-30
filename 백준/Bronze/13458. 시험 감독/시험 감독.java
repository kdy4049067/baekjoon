import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] participant = new int[n];

        for(int i = 0; i < n; i++){
            participant[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            participant[i] -= b;
        }

        long result = n;

        for(int i = 0; i < n; i++){
            if(participant[i] <= 0) continue;

            result += (int)Math.ceil(participant[i] / (double)c);
        }

        System.out.println(result);
    }

}
