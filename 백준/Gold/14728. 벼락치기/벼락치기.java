import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        ArrayList<Score> score = new ArrayList<>();
        for(int i = 0; i < n; i++){
            score = new ArrayList<>();
        }
        score.add(new Score(0,0));

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            score.add(new Score(time,val));
        }

        int dp[][] = new int[n+1][total+1];

        for(int i = 1; i < score.size(); i++){
            Score s = score.get(i);
            int t = s.time;
            int v = s.val;
            for(int j = 1; j <= total; j++){
                if(j-t < 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-t] + v);
            }
        }
        int max= 0;
        for(int i = 1; i <= total; i++){
            max = Math.max(dp[n][i],max);
        }
        System.out.println(max);
    }

    static class Score{
        int time;
        int val;
        public Score(int time, int val){
            this.time = time;
            this.val = val;
        }
    }
}
