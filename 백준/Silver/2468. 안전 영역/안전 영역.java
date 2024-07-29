import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] dx = new int[]{0,0,-1,1};
    static int[]dy = new int[]{-1,1,0,0};
    static boolean[][] check;
    static int n;
    static int result = 0;
    static int max = 0;
    static int ans = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;
                if(val > max) max = val;
            }
        }
        for(int p = 0; p <= max; p++) {
            result = 0;
            check = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    if (!check[i][j] && graph[i][j] > p){
                        bfs(i, j, p);
                        result++;
                    }
                }
            }
            if(ans < result) ans = result;
        }
        System.out.println(ans);
    }
    public static void bfs(int x, int y, int k){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        check[x][y] = true;
            while(!q.isEmpty()) {
                int[] index = q.poll();
                int xx = index[0];
                int yy = index[1];
                    for (int i = 0; i < 4; i++) {
                        int new_x = xx + dx[i];
                        int new_y = yy + dy[i];
                        if (0 <= new_x && new_x < n && 0 <= new_y && new_y < n && !check[new_x][new_y]
                                && graph[new_x][new_y] > k) {
                            q.add(new int[]{new_x, new_y});
                            check[new_x][new_y] = true;
                        }
                    }
                }
            }

}
