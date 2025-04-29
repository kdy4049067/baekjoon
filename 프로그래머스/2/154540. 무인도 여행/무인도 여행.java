import java.util.*;

class Solution {
    private static Queue<int[]> q = new LinkedList<>();
    private static boolean[][] visited;
    private static final int[] dx = new int[]{0,0,-1,1};
    private static final int[] dy = new int[]{1,-1,0,0};
    private ArrayList<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X')
                    bfs(i, j, maps);
            }
        }
        Collections.sort(list);
        if(list.size() == 0) return new int[]{-1};
        
        return list.stream()
            .mapToInt(Integer::intValue).toArray();
        
    }
    
    public void bfs(int x, int y, String[] maps){
        int count = 0;
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] poll = q.poll();
            count += maps[poll[0]].charAt(poll[1]) -'0';
            for(int i = 0; i < 4; i++){
                int moveX = poll[0] + dx[i];
                int moveY = poll[1] + dy[i];
                
                if(moveX < 0 || moveX >= maps.length || moveY < 0 || moveY >= maps[0].length() || visited[moveX][moveY] || maps[moveX].charAt(moveY) == 'X') continue;
                
                if(maps[moveX].charAt(moveY) != 'X'){
                    q.add(new int[]{moveX, moveY});
                    visited[moveX][moveY] = true;
                }
            }
        }
        
        list.add(count);
    }
    
}