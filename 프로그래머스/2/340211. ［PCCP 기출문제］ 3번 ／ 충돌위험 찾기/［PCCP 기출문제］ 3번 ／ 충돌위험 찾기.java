import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static Queue<int[]>[] memory;
    static int size;
    static int answer;

    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        memory = new LinkedList[size];
        for(int i = 0; i < size; i++){
            memory[i] = new LinkedList<>();
        }
        memo(points, routes);
        crash();
        return answer;
    }

    public static void crash(){
        int count = 0;
        while(count != size){
            int map[][] = new int[101][101];
            count = 0;
            for(int i = 0; i < size; i++){
                if(memory[i].isEmpty()){
                    count++;
                    continue;
                }
                int [] temp = memory[i].poll();
                map[temp[0]][temp[1]]++;
            }
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){
                    if(map[i][j] > 1) answer++;
                }
            }
        }
    }

    public static void memo(int [][] points, int [][] routes){
        for(int i = 0; i < size; i++){
            int [] point = points[routes[i][0] - 1];
            int x = point[0];
            int y = point[1];
            memory[i].add(new int[]{x,y});
            for(int j = 1; j < routes[0].length; j++){
                int [] np = points[routes[i][j] - 1];
                int nx = np[0];
                int ny = np[1];

                int xp = nx - x;
                int yp = ny - y;

                while(xp != 0){
                    if(xp > 0){
                        xp--;
                        x++;
                        memory[i].add(new int[]{x,y});
                    }
                    else{
                        xp++;
                        x--;
                        memory[i].add(new int[]{x,y});
                    }
                }
                while(yp != 0){
                    if(yp > 0){
                        yp--;
                        y++;
                        memory[i].add(new int[]{x, y});
                    }
                    else{
                        yp++;
                        y--;
                        memory[i].add(new int[]{x, y});
                    }
                }
            }

        }
    }
}
