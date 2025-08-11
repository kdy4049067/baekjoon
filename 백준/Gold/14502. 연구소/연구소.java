import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int row;
    private static int col;
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};
    private static int count = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0);
        System.out.println(count);
    }

    private static void comb(int count){
        if(count == 3){
            bfs();
            return;
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    comb(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        int[][] temp = new int[row][col];
        for(int i = 0; i < row; i++){
            temp[i] = map[i].clone();
        }

        while(!q.isEmpty()){
            int[] virus = q.poll();
            for(int i = 0; i < 4; i++){
                int virusX = virus[0] + dx[i];
                int virusY = virus[1] + dy[i];

                if(virusX < 0 || virusX >= row || virusY < 0 || virusY >= col) continue;

                if(temp[virusX][virusY] == 0){
                    q.add(new int[]{virusX, virusY});
                    temp[virusX][virusY] = 2;
                }
            }
        }

        countOfNoVirus(temp);
    }

    private static void countOfNoVirus(int[][] temp){
        int result = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(temp[i][j] == 0) result++;
            }
        }

        count = Math.max(result, count);
    }

}
