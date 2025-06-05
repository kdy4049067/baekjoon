import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = new int[]{2,1,-1,-2,2,1,-1,-2};
    static int[] dy = new int[]{1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            int len = Integer.parseInt(br.readLine());

            String[] startPosition = br.readLine().split(" ");
            String[] endPosition = br.readLine().split(" ");

            int startX = Integer.parseInt(startPosition[0]);
            int startY = Integer.parseInt(startPosition[1]);

            int endX = Integer.parseInt(endPosition[0]);
            int endY = Integer.parseInt(endPosition[1]);

            if((startX == endX) && (startY == endY)){
                System.out.println(0);
                continue;
            }

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[len][len];
            boolean check = false;

            q.add(new int[]{startX, startY, 0});
            visit[startX][startY] = true;

            while(!q.isEmpty()){
                int[] position = q.poll();
                int x = position[0];
                int y = position[1];

                for(int j = 0; j < 8; j++){
                    int moveX = x + dx[j];
                    int moveY = y + dy[j];

                    if(moveX == endX && moveY == endY) {
                        System.out.println(position[2] + 1);
                        check = true;
                        break;
                    }
                    if(moveX < 0 || moveX >= len || moveY < 0 || moveY >= len || visit[moveX][moveY]){
                        continue;
                    }

                    q.add(new int[]{moveX, moveY, position[2]+1});
                    visit[moveX][moveY] = true;
                }
                if(check) break;
            }
        }


    }

}
