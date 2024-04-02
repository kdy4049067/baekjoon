import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leak = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int [] arr = new int[leak];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < leak; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - start +1 <= length){
                continue;
            }
            start = arr[i];
            count++;
        }
        System.out.println(count);
    }
}
