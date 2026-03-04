import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static Queue<int[]> q = new LinkedList<>();
    private static int result = -1;
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static final int[] dy = new int[]{1, -1, 0, 0};
    private static int width;
    private static int height;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[width][height];

        boolean checkAllDone = true;

        for(int i = 0; i < width; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < height; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.add(new int[]{i, j});
                if(map[i][j] == 0) checkAllDone = false;
            }
        }

        if(checkAllDone){
            System.out.println(0);
            return;
        }

        bfs();
        if(!isFinished()){
            System.out.println(-1);
            return;
        }

        System.out.println(result);
    }

    private static void bfs(){
        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i = 0; i < qSize; i++){
                int[] target = q.poll();
                int x = target[0];
                int y = target[1];

                for(int j = 0; j < 4; j++){
                    int moveX = x + dx[j];
                    int moveY = y + dy[j];

                    if(moveX < 0 || moveX >= width || moveY < 0 || moveY >= height){
                        continue;
                    }

                    if(map[moveX][moveY] == -1) continue;

                    if(map[moveX][moveY] == 0) {
                        q.add(new int[]{moveX, moveY});
                        map[moveX][moveY] = 1;
                    }
                }
            }

            result++;

        }
    }

    private static boolean isFinished(){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }

}
