import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int moveX[] = new int[]{-1,1,0,0};
    static int moveY[] = new int[]{0,0,-1,1};
    static int graph[][];
    static boolean check[][];
    static int n;
    static int m;
    static int count;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        check = new boolean[m][n];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int leftDownX = Integer.parseInt(st.nextToken());
            int leftDownY = Integer.parseInt(st.nextToken());
            int rightUpX = Integer.parseInt(st.nextToken());
            int rightUpY = Integer.parseInt(st.nextToken());

            for(int j = rightUpY-1; j >= leftDownY; j--){
                for(int l = rightUpX-1; l >= leftDownX; l--){
                    graph[j][l] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int result_count = 0;

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 0 && !check[i][j]){
                    count = 1;
                    bfs(i,j);
                    result_count++;
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result_count);
        for(int res : result){
            System.out.printf("%d ", res);
        }

    }

    static void bfs(int x, int y){
        check[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int move_x = x + moveX[i];
            int move_y = y + moveY[i];
            if(move_x >= 0 && move_y >= 0 && move_x < m && move_y < n && graph[move_x][move_y] == 0 && !check[move_x][move_y]){
                bfs(move_x, move_y);
                count++;
            }
        }
    }

}
