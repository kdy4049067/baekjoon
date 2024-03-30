import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean check[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] graph = new int[height+1][width+1];
        for (int i = 1; i <= height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= width; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] temp = new int[2][width+2];
        int[][] result = new int[height+1][width+1];
        result[1][1] = graph[1][1];

        for(int i = 2; i <= width; i++){
            result[1][i] = graph[1][i] + result[1][i-1];
        }

        for(int i = 2; i <= height; i++){
            temp[0][0] = result[i-1][1];
            for(int j = 1; j <= width; j++){
                temp[0][j] = Math.max(temp[0][j-1], result[i-1][j]) + graph[i][j];
            }
            temp[1][width+1] = result[i-1][width];
            for(int j = width; j >= 1; j--){
                temp[1][j] = Math.max(temp[1][j+1], result[i-1][j]) + graph[i][j];
            }
            for(int j = 1; j <= width; j++){
                result[i][j] = Math.max(temp[0][j],temp[1][j]);
            }

        }
        System.out.println(result[height][width]);

    }
}