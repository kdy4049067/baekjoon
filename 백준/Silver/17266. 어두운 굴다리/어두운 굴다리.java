import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int len = Integer.parseInt(br.readLine());
        int light = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] pos = new int[light];

        for(int i = 0; i < light; i++){
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[light+1];
        diff[0] = pos[0];
        diff[light] = len - pos[light-1];

        for(int i = 1; i < light; i++){
            diff[i] = (int)Math.ceil((double) (pos[i] - pos[i - 1]) / 2);
        }

        Arrays.sort(diff);

        System.out.println(diff[light]);
    }

}
