import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] amount = new int[day];
        int max = 0;
        int end = 1000000000;

        for (int i = 0; i < day; i++) {
            amount[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, amount[i]);
        }

        while(max <= end){
            int mid = (max + end) / 2;
            
            int cnt = 1;
            int money = mid;
            for(int i = 0; i < day; i++){
                if(money < amount[i]){
                    money = mid;
                    cnt += 1;
                }
                money -= amount[i];
            }
            if(cnt > count)
                max = mid + 1;
            else 
                end = mid - 1;
        }

        System.out.println(max);
    }

}