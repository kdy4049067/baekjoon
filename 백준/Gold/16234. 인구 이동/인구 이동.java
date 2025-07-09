import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int result = 0;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[n][n];
            boolean ch = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]) {
                        int result = bfs(i, j, l, r);
                        if (list.size() > 1) {
                            calculate(result);
                            ch = true;
                        }
                    }
                }
            }

            if(!ch){
                System.out.println(result);
                return;
            }
            result++;
        }
    }

    public static int bfs(int startX, int startY, int l, int r){
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        int sum = map[startX][startY];

        q.add(new int[]{startX, startY});
        list.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for(int k = 0; k < 4; k++){
                int moveX = x + dx[k];
                int moveY = y + dy[k];

                if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || visited[moveX][moveY]) continue;

                if(Math.abs((map[x][y]-map[moveX][moveY])) <= r && Math.abs((map[x][y] - map[moveX][moveY])) >= l){
                    visited[moveX][moveY] = true;
                    q.add(new int[]{moveX, moveY});
                    list.add(new int[]{moveX, moveY});
                    sum += map[moveX][moveY];
                }
            }
        }

        return sum / list.size();
    }

    public static void calculate(int result){
        for(int[] res : list){
            map[res[0]][res[1]] = result;
        }
    }

}
