import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dice;
    static int n;
    static int m;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int command = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[]{0, 0, 0, 0, 0, 0};

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < command; i++){
            int commandNumber = Integer.parseInt(st.nextToken());

            if (commandNumber == 1) {
                y++;
                if(checkBoundary(x, y)){
                    y--;
                    continue;
                }
                moveEast();
                mapZeroOrNot(x, y);
                sb.append(dice[0]).append("\n");
            }

            if(commandNumber == 2){
                y--;
                if(checkBoundary(x, y)){
                    y++;
                    continue;
                }
                moveWest();
                mapZeroOrNot(x, y);
                sb.append(dice[0]).append("\n");
            }

            if(commandNumber == 3){
                x--;
                if(checkBoundary(x, y)){
                    x++;
                    continue;
                }
                moveNorth();
                mapZeroOrNot(x, y);
                sb.append(dice[0]).append("\n");
            }

            if(commandNumber == 4){
                x++;
                if(checkBoundary(x, y)){
                    x--;
                    continue;
                }
                moveSouth();
                mapZeroOrNot(x, y);
                sb.append(dice[0]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void moveEast(){
        int origin1 = dice[0];
        int origin5 = dice[4];
        int origin3 = dice[2];
        int origin6 = dice[5];

        dice[0] = origin5;
        dice[2] = origin6;
        dice[4] = origin3;
        dice[5] = origin1;
    }

    public static void moveWest(){
        int origin1 = dice[0];
        int origin5 = dice[4];
        int origin3 = dice[2];
        int origin6 = dice[5];

        dice[4] = origin1;
        dice[5] = origin3;
        dice[2] = origin5;
        dice[0] = origin6;
    }

    public static void moveNorth(){
        int origin1 = dice[0];
        int origin4 = dice[3];
        int origin3 = dice[2];
        int origin2 = dice[1];

        dice[3] = origin1;
        dice[2] = origin4;
        dice[1] = origin3;
        dice[0] = origin2;
    }

    public static void moveSouth(){
        int origin1 = dice[0];
        int origin4 = dice[3];
        int origin3 = dice[2];
        int origin2 = dice[1];

        dice[0] = origin4;
        dice[3] = origin3;
        dice[2] = origin2;
        dice[1] = origin1;
    }

    public static void mapZeroOrNot(int x, int y){
        if(map[x][y] == 0)
            map[x][y] = dice[2];
        else{
            dice[2] = map[x][y];
            map[x][y] = 0;
        }
    }

    public static boolean checkBoundary(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}
