import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int result = Integer.MAX_VALUE;

        int startIndex = 0;
        int endIndex = n-1;

        int[] index = new int[2];

        while(startIndex < endIndex) {
            int start = liquid[startIndex];
            int end = liquid[endIndex];

            if(Math.abs(start+end) < result){
                index[0] = start;
                index[1] = end;
                result = Math.abs(start+end);

                if(result == 0) break;
            }

            if(start + end < 0){
                startIndex++;
            }
            else endIndex--;
        }

        System.out.println(index[0] + " " + index[1]);
    }

}
