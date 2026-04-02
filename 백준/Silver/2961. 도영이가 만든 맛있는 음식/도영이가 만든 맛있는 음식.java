import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] food;
    private static int n;
    private static int sumS = 1;
    private static int sumB = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        food = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            food[i][0] = sour;
            food[i][1] = bitter;
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                dfs(i, 0, j);
                sumS = 1;
                sumB = 0;
            }
        }

        System.out.println(min);
    }

    private static void dfs(int index, int depth, int count){
        if(depth == count){
            return;
        }

        for(int i = index; i < n; i++){
            sumS *= food[index][0];
            sumB += food[index][1];
            min = Math.min(min, Math.abs(sumS - sumB));
            dfs(i+1, depth+1, count);
            sumS /= food[index][0];
            sumB -= food[index][1];
        }
    }

}
