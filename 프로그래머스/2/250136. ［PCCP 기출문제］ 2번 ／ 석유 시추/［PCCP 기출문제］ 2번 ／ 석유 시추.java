import java.util.*;

class Solution {
    static int[] oil;
    public int solution(int[][] land) {
        boolean [][] visited = new boolean[land.length][land[0].length];
        oil = new int[land[0].length];

        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1 && !visited[i][j])
                bfs(i,j,land, visited);
            }
        }
        return Arrays.stream(oil).max().getAsInt();
    }

    public void bfs(int x, int y, int[][] land, boolean[][] visited){
        int [] dx = new int[]{0,0,-1,1};
        int [] dy = new int[]{1,-1,0,0};

        Queue<int []> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});
        int count = 1;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            set.add(temp[1]);
            for(int i = 0; i < 4; i++){
                int moveX = temp[0] + dx[i];
                int moveY = temp[1] + dy[i];
                if(moveX < 0 || moveX >= land.length || moveY < 0 || moveY >= land[0].length || visited[moveX][moveY])
                    continue;
                if(land[moveX][moveY] == 1){
                    q.add(new int[]{moveX, moveY});
                    visited[moveX][moveY] = true;
                    count++;

                }
            }
        }
        for(int index : set){
            oil[index] += count;
        }
    }
}