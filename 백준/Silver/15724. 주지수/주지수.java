import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        int[][] sum = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + map[i][j];
            }
        }

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());

            int answer = 0;

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j <= x2; j++){
                answer += (sum[j][y2] - sum[j][y1-1]);
            }

            System.out.println(answer);
        }


    }

}
