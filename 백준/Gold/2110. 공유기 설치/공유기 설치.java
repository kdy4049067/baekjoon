import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] house;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int max = 0;

        int left = 1;
        int right = house[n-1] - house[0];

        while(left <= right){
            int mid = (left + right) / 2;
            int start = house[0];
            int cnt = 1;

            for(int i = 0; i < n; i++){
                if(house[i] - start >= mid){
                    cnt++;
                    start = house[i];
                }
            }

            if(cnt >= c){
                left = mid+1;
                max = mid;
            }
            else{
                right = mid-1;
            }
        }

        System.out.println(max);
    }

}
