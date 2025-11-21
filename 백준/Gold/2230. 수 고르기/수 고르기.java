import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while(true){
            if(start == arr.length-1) break;
            if(end == arr.length){
                start++;
                continue;
            }

            if(arr[end] - arr[start] < m) end++;
            else{
                min = Math.min(arr[end] - arr[start], min);
                start++;
            }
        }

        System.out.println(min);
    }

}
