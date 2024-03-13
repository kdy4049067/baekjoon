import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] graph;
    static int width = 0;
    static int height = 0;
    static int max = 0;
    static int size = 0;
    static boolean[][] check;
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        graph = new int[height][width];
        check = new boolean[height][width];
        for(int i = 0; i < height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (!check[i][j] && graph[i][j] == 1) {
                    count++;
                    size = 1;
                    dfs(i,j);
                    max = max < size? size: max;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void dfs(int x, int y){
        int[] move_x = new int[]{0,0,-1,1};
        int[] move_y = new int[]{-1,1,0,0};
            check[x][y] = true;
            for(int i = 0; i < 4; i++){
                int xx = move_x[i] + x;
                int yy = move_y[i] + y;
                if(0 > xx || xx > height-1 || 0 > yy || yy > width-1 || check[xx][yy])
                    continue;
                if(graph[xx][yy] == 1) {
                    size++;
                    dfs(xx, yy);
                }
            }
        }
    }