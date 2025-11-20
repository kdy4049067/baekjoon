import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] money;
    private static int n;
    private static int total;
    private static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        money = new int[n];

         for(int i = 0; i < n; i++){
             money[i] = Integer.parseInt(st.nextToken());
         }

         total = Integer.parseInt(br.readLine());

         Arrays.sort(money);

         binarySearch(0, money[n-1]);

        System.out.println(answer);
    }

    private static void binarySearch(int start, int end){
        if(start > end) return;

        int mid = (start+end) / 2;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += Math.min(money[i], mid);
        }

        if(sum <= total){
            answer = mid;
            binarySearch(mid+1, end);
        }

        else{
            binarySearch(start, mid-1);
        }
    }

}
