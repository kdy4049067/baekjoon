import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[] move_x = new int[]{-1,1,0,0};
    final static int[] move_y = new int[]{0,0,-1,1};
    static int[][] trash;
    static int n;
    static int m;
    static boolean [][] check;
    static int count = 0;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n =  Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        trash = new int[n+1][m+1];
        check = new boolean[n+1][m+1];
        int max= 0;

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            trash[height][width] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(trash[i][j] == 1 && !check[i][j]) {
                    count = 0;
                    bfs(i, j);
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x,y});
        count++;
        check[x][y] = true;

        while(!q.isEmpty()){
            int[] poll_q = q.poll();
            for(int i = 0; i < 4; i++){
                int moved_x = poll_q[1] + move_x[i];
                int moved_y = poll_q[0] + move_y[i];
                if(1 <= moved_y && moved_y <= n && 1 <= moved_x && moved_x <= m){
                    if(trash[moved_y][moved_x] != 1 || check[moved_y][moved_x])
                        continue;
                    q.add(new int[]{moved_y,moved_x});
                    check[moved_y][moved_x] = true;
                    count++;
                }
            }

        }
    }
}
