import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size;
    static int[][] graph;
    static List<Integer> result;
    static boolean[][] check;
    static int[] move_x = {0,0,-1,1};
    static int[] move_y = {-1,1,0,0};
    static int c = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        result = new LinkedList<>();
        check = new boolean[size][size];
        StringBuilder sb = new StringBuilder();
        c = 1;
        for(int i = 0; i < size; i++){
            String str = br.readLine();
            for(int j = 0; j < size; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        int count = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if(graph[i][j] == 1 && !check[i][j]) {
                    dfs(i, j);
                    result.add(c);
                    c = 1;
                    count++;
                }

            }
        }
        Collections.sort(result);
        System.out.println(count);
        for(int res : result)
            System.out.println(res);


    }

    public static void dfs(int x, int y){
        check[x][y] = true;
        for(int i = 0; i < 4; i++){
            int xx = move_x[i] + x;
            int yy = move_y[i] + y;
            if(xx>=0 && yy>=0 && xx<size && yy<size && !check[xx][yy] && graph[xx][yy]==1 ) {
                c++;
                dfs(xx, yy);
            }
        }
    }
}
