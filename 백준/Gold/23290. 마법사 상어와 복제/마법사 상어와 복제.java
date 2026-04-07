import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dy = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
    private static int sharkX;
    private static int sharkY;
    private static ArrayList<Fish> list;
    private static ArrayList<Fish> copyList;
    private static int[][] check = new int[5][5];
    private static final int[] sharkDx = new int[]{-1, 0, 1, 0};
    private static final int[] sharkDy = new int[]{0, -1, 0, 1};
    private static int max = 0;
    private static int[] bestPath = new int[3];
    private static int[] tempPath = new int[3];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int fishX = Integer.parseInt(st.nextToken());
            int fishY = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            list.add(new Fish(fishX, fishY, direction));
        }

        st = new StringTokenizer(br.readLine());
        sharkX = Integer.parseInt(st.nextToken());
        sharkY = Integer.parseInt(st.nextToken());

        for(int j = 0; j < s; j++){
            max = -1;
            boolean[][] visited = new boolean[5][5];

            stepOne_One();
            stepTwo();
            stepThree_One(sharkX, sharkY, 0, 0, visited);
            stepThree_Two();
            minusCheck();
            stepOne_Two();
        }

        System.out.println(numOfFish());
    }

    private static void stepOne_One(){
        copyList = new ArrayList<>();
        for (Fish f : list) {
            copyList.add(new Fish(f.x, f.y, f.direction)); // 깊은 복사
        }
    }

    private static void stepOne_Two(){
        list.addAll(copyList);
    }

    private static void stepTwo(){
        ArrayList<Fish> nextList = new ArrayList<>();
        for (Fish f : list) {
            boolean moved = false;
            int currentDir = f.direction;

            for (int i = 0; i < 8; i++) {
                int moveX = f.x + dx[currentDir];
                int moveY = f.y + dy[currentDir];

                if (moveX > 0 && moveX <= 4 && moveY > 0 && moveY <= 4 && check[moveX][moveY] == 0 &&
                !(moveX == sharkX && moveY == sharkY)) {
                    nextList.add(new Fish(moveX, moveY, currentDir));
                    moved = true;
                    break;
                }

                currentDir = (currentDir == 1) ? 8 : currentDir-1;
            }

            if (!moved) {
                nextList.add(new Fish(f.x, f.y, f.direction));
            }
        }

        list = nextList;
    }

    private static void stepThree_One(int x, int y, int depth, int fishCount, boolean[][] visited){
        if (depth == 3) {
            if(fishCount > max){
                max = fishCount;
                for(int i = 0; i < 3; i++){
                    bestPath[i] = tempPath[i];
                }
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + sharkDx[i];
            int ny = y + sharkDy[i];

            if (outOfBound(nx, ny)) continue;

            if (visited[nx][ny]) {
                tempPath[depth] = i;
                stepThree_One(nx, ny, depth + 1, fishCount, visited);
            } else {
                visited[nx][ny] = true;
                tempPath[depth] = i;
                stepThree_One(nx, ny, depth + 1, fishCount + canEat(nx, ny), visited);
                visited[nx][ny] = false;
            }
        }
    }

    private static void stepThree_Two(){
        for(int i = 0; i < 3; i++){
            int index = bestPath[i];
            sharkX += sharkDx[index];
            sharkY += sharkDy[index];

            if (canEat(sharkX, sharkY) > 0) {
                list.removeIf(f -> f.x == sharkX && f.y == sharkY);
                check[sharkX][sharkY] = 3;
            }
        }
    }

    private static void minusCheck(){
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(check[i][j] > 0)
                    check[i][j]--;
            }
        }
    }

    private static int canEat(int x, int y){
        int count = 0;
        for(Fish f : list){
            if(f.x == x &&  f.y == y) count++;
        }

        return count;
    }

    private static boolean outOfBound(int x, int y){
        return (x <= 0 || x > 4 || y <= 0 || y > 4);
    }

    private static int numOfFish(){
        return list.size();
    }

    public static class Fish{
        public int x;
        public int y;
        public int direction;

        public Fish(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

}
