import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int curTime = 0;
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};
    private static Deque<int[]> q;
    private static int[][] apple;
    private static int[][] map;
    private static int n;
    private static int curDir = 0;
    private static HashMap<Integer, String> hash = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int countOfApple = Integer.parseInt(br.readLine());
        apple = new int[n+1][n+1];
        map = new int[n+1][n+1];
        map[1][1] = 1;
        StringTokenizer st;

        for(int i = 0; i < countOfApple; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apple[x][y] = 1;
        }

        int move = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        q.addLast(new int[]{1, 1});

        for(int i = 0; i < move; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            hash.put(time, dir);
        }
        move();

        System.out.println(curTime);
    }

    private static void move(){
        while(true){
            if(hash.containsKey(curTime)){
                if(hash.get(curTime).equals("D")){
                    curDir = (curDir + 1) % 4;
                }
                else{
                    curDir = (curDir + 3) % 4;
                }
            }
            curTime++;

            int moveX = 0;
            int moveY = 0;
            int[] pos = q.peekLast();
            int x = pos[0];
            int y = pos[1];

            moveX = x + dx[curDir];
            moveY = y + dy[curDir];

            if(moveX > n || moveX <= 0 || moveY > n || moveY <= 0) return;
            if(map[moveX][moveY] == 1) return;

            if(apple[moveX][moveY] == 1){
                q.addLast(new int[]{moveX, moveY});
                map[moveX][moveY] = 1;
                apple[moveX][moveY] = 0;
            }
            else{
                int[] cut = q.pollFirst();
                q.addLast(new int[]{moveX, moveY});
                map[cut[0]][cut[1]] = 0;
                map[moveX][moveY] = 1;
            }
        }
    }

}
