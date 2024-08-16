import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        ArrayList<coin> list = new ArrayList<>();
        for(int i = 0; i <= num; i++){
            list = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            list.add(new coin(v,n));
        }

        list.add(new coin(0,0));

        int [][]dp = new int[num+1][total+1];
        for(int i = 0; i <= num; i++){
            dp[i][0] = 1;
        }
        Collections.sort(list);
        
        for(int i = 1; i <= num; i++){
            coin c = list.get(i);
            for(int j = 1; j <= total; j++){
                for(int k = 0; k <= c.num; k++){
                    if(j - (c.val * k) < 0 ) break;
                    dp[i][j] += dp[i-1][j - (c.val * k)];
                }
            }
        }

        System.out.println(dp[num][total]);

    }

    public static class coin implements Comparable<coin>{
        int val;
        int num;
        public coin(int val, int num){
            this.val = val;
            this.num = num;
        }
        @Override
        public int compareTo(coin o){
            return this.val - o.val;
        }
    }
}
