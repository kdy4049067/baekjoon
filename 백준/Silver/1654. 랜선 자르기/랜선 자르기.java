import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());
        int lan[] = new int[n];
        long max = 0;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            lan[i] = num;
            if(num > max)
                max = num;
        }

        max++;

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (min+max) / 2;
            long result =0;

            for(int i = 0; i < n; i++){
                result += lan[i] / mid;
            }

            if(result >= need){
                min = mid + 1;
            }
            else{
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}

