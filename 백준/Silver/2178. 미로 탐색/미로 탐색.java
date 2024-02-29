import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][] graph;
    static int width;
    static boolean[][] check;
    static int height;

    public static void main(String []args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        graph = new int[height][width];
        check = new boolean[height][width];

        for(int i = 0; i < height; i++){
            String value = br.readLine();
            for(int j= 0; j < width; j++){
                graph[i][j] = Character.getNumericValue(value.charAt(j));
            }
        }
        bfs(0,0);

        System.out.println(graph[height-1][width-1]);

    }

    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int [] move_x = new int[]{1,0,-1,0};
        int [] move_y = new int[]{0,-1,0,1};
        while(!q.isEmpty()){
            int []value = q.poll();
            int x_value = value[0];
            int y_value = value[1];
                for(int i = 0; i < 4; i++){
                    int moved_x = x_value + move_x[i];
                    int moved_y = y_value + move_y[i];
                    if(moved_x <0 || moved_y < 0 || moved_x > height -1|| moved_y > width-1)
                        continue;
                    if(graph[moved_x][moved_y] == 1 && !check[moved_x][moved_y]) {
                        if(moved_x == height-1 && moved_y == width-1){
                            graph[moved_x][moved_y] = graph[x_value][y_value] + 1;
                            return;
                        }
                        check[moved_x][moved_y] = true;
                        q.add(new int[]{moved_x, moved_y});
                        graph[moved_x][moved_y] = graph[x_value][y_value] + 1;
                    }
                }

        }
    }
}
