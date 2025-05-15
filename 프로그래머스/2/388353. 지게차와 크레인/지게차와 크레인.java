import java.util.*;

class Solution {
    static final int max = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] check;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    
    public static int solution(String[] storage, String[] requests) {
        int answer = 0;
        map = new int[storage.length][storage[0].length()];
        
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[0].length(); j++){
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for(int i = 0; i < requests.length; i++){
            int request = requests[i].charAt(0) - 'A';
            
            if(requests[i].length() == 2){
                type1(map, request);
                continue;
            }
            type2(map, request);
            
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != -1) answer++;
            }
        }
        return answer;
        
    }
    
    public static void type1(int[][] map, int request){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == request){
                    map[i][j] = -1;
                }
            }
        }
    }
    
    public static void type2(int[][] map, int request){
        check = new int[map.length][map[0].length];
        for(int i = 0; i < check.length; i++){
            Arrays.fill(check[i], max);
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(i != 0 && i != map.length-1 && j != 0 && j != map[0].length-1) continue;
                if(check[i][j] != max) continue;
                if(map[i][j] != -1){
                    check[i][j] = 1;
                    if(map[i][j] == request){
                        list.add(new int[]{i, j});
                    }
                    continue;
                }
                check[i][j] = 0;
                q.add(new int[] {i,j});
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(!validation(nx, ny) || check[nx][ny] != max) continue;
                        
                        if(map[nx][ny] == -1){
                            check[nx][ny] = 0;
                            q.add(new int[]{nx, ny});
                            continue;
                        }
                        check[nx][ny] = 1;
                        
                        if(map[nx][ny] == request){
                            list.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        
        for(int[] remove : list){
            map[remove[0]][remove[1]] = -1;
        }
    }
    
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < map.length && ny < map[0].length) return true;
        return false;
    }
    
}