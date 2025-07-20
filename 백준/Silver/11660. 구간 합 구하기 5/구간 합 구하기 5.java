import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] sum;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        sum = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(j != 0)
                    sum[i][j] += map[i][j] + sum[i][j-1];
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(subSum(x1, y1, x2, y2));
        }

    }

    private static int subSum(int x1, int y1, int x2, int y2){
        int result = 0;

        int sum1 = sum[x1-1][y2-1] - sum[x1-1][y1-1] + map[x1-1][y1-1];
        int sum2 = sum[x2-1][y2-1] - sum[x2-1][y1-1] + map[x2-1][y1-1];

        if(x1 == x2) return sum1;

        result = sum1 + sum2;

        for(int i = x1+1; i < x2; i++){
            result += sum[i-1][y2-1] - sum[i-1][y1-1] + map[i-1][y1-1];
        }

        return result;
    }

}
