import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static int[][] map;
    private static int result = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        st = new StringTokenizer(br.readLine());
        int robotX = Integer.parseInt(st.nextToken());
        int robotY = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(robotX, robotY, robotDir);
        System.out.println(result);
    }

    private static void bfs(int x, int y, int dir){
        Queue<int[]> robot = new LinkedList<>();

        robot.add(new int[]{x, y, dir});

        while(!robot.isEmpty()){
            boolean needClean = false;

            int[] pos = robot.poll();
            int robotX = pos[0];
            int robotY = pos[1];
            int robotDir = pos[2];

            if(map[robotX][robotY] == 0){
                map[robotX][robotY] = 2;
                result++;
            }

            int moveX = 0;
            int moveY = 0;

            for(int i = 0; i < 4; i++){
                moveX = robotX + dx[i];
                moveY = robotY + dy[i];

                if(map[moveX][moveY] == 0)
                    needClean = true;
            }

            int moveRobotX = robotX;
            int moveRobotY = robotY;

            if(!needClean){
                if(robotDir == 0){
                    moveRobotX = robotX + dx[2];
                    moveRobotY = robotY + dy[2];
                }
                else if(robotDir == 1){
                    moveRobotX = robotX + dx[3];
                    moveRobotY = robotY + dy[3];
                }
                else if(robotDir == 2){
                    moveRobotX = robotX + dx[0];
                    moveRobotY = robotY + dy[0];
                }
                else if(robotDir == 3){
                    moveRobotX = robotX + dx[1];
                    moveRobotY = robotY + dy[1];
                }

                if(map[moveRobotX][moveRobotY] == 1) break;
                else robot.add(new int[]{moveRobotX, moveRobotY, robotDir});
            }

            else{
                while(map[moveRobotX][moveRobotY] != 0){
                    if(robotDir == 0) {
                        robotDir = 3;
                        moveRobotX = robotX + dx[robotDir];
                        moveRobotY = robotY + dy[robotDir];
                    }
                    else if(robotDir == 1){
                        robotDir = 0;
                        moveRobotX = robotX + dx[robotDir];
                        moveRobotY = robotY + dy[robotDir];
                    }
                    else if(robotDir == 2) {
                        robotDir = 1;
                        moveRobotX = robotX + dx[robotDir];
                        moveRobotY = robotY + dy[robotDir];
                    }
                    else if(robotDir == 3) {
                        robotDir = 2;
                        moveRobotX = robotX + dx[robotDir];
                        moveRobotY = robotY + dy[robotDir];
                    }
                }

                robot.add(new int[]{moveRobotX, moveRobotY, robotDir});
            }
        }
    }
}
