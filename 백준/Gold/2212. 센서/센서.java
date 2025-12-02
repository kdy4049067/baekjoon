import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Integer[] diff = new Integer[n-1];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;

        for(int i = 0; i < n-1; i++){
            diff[i] = arr[i+1] - arr[i];
            result += diff[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        if(k >= n){
            System.out.println(0);
            return;
        }
        
        for(int i = 0; i < k-1; i++){
            result -= diff[i];
        }

        System.out.println(result);
    }
}
