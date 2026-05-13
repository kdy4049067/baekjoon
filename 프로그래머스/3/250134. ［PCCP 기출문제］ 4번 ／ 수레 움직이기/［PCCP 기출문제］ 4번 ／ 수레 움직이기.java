import java.util.*;

class Solution {
    
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int blueGoalX = 0;
    private int blueGoalY = 0;
    private int redGoalX = 0;
    private int redGoalY = 0;
    private int blueX = 0;
    private int blueY = 0;
    private int redX = 0;
    private int redY = 0;
    private int height = 0;
    private int width = 0;
    private boolean[][] blueMove;
    private boolean[][] redMove;
    private Position[] bluePosition;
    private Position[] redPosition;
    private int startBlueX = 0;
    private int startBlueY = 0;
    private int startRedX = 0;
    private int startRedY = 0;
    private int result = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        height = maze.length;
        width = maze[0].length;
        
        blueMove = new boolean[height][width];
        redMove = new boolean[height][width];
        
        bluePosition = new Position[16];
        redPosition = new Position[16];
        
        Arrays.fill(bluePosition, new Position(-1, -1));
        Arrays.fill(redPosition, new Position(-1, -1));
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(maze[i][j] == 1){
                    redX = i;
                    redY = j;
                    startRedX = i;
                    startRedY = j;
                }
                else if(maze[i][j] == 2){
                    blueX = i;
                    blueY = j;
                    startBlueX = i;
                    startBlueY = j;
                }
                else if(maze[i][j] == 3){
                    redGoalX = i;
                    redGoalY = j;
                }
                else if(maze[i][j] == 4){
                    blueGoalX = i;
                    blueGoalY = j;
                }
            }
        }
        
        blueMove[blueX][blueY] = true;
        redMove[redX][redY] = true;
        
        moveBlue(maze, 0, blueX, blueY);
        
        if(result == Integer.MAX_VALUE) return 0;
        return result;
    }
    
    private void moveBlue(int[][] maze, int depth, int x, int y){
        if(x == blueGoalX && y == blueGoalY){
            moveRed(maze, 0, redX, redY);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            
            if(canMove(maze, blueMove, moveX, moveY)){
                blueMove[moveX][moveY] = true;
                bluePosition[depth] = new Position(moveX, moveY);
                moveBlue(maze, depth+1, moveX, moveY);
                blueMove[moveX][moveY] = false;
                bluePosition[depth] = new Position(-1, -1);
            }
        }
    }
    
    private void moveRed(int[][] maze, int depth, int x, int y){
        if(x == redGoalX && y == redGoalY){
            result = Math.min(result, simulation());
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            
            if(canMove(maze, redMove, moveX, moveY)){
                redMove[moveX][moveY] = true;
                redPosition[depth] = new Position(moveX, moveY);
                moveRed(maze, depth+1, moveX, moveY);
                redMove[moveX][moveY] = false;
                redPosition[depth] = new Position(-1, -1);
            }
        }
    } 
    
    private int simulation(){
        int blueSize = 0;
        int redSize = 0;
        
        for(int i = 0; i < 16; i++){
            if(bluePosition[i].x != -1 && bluePosition[i].y != -1)
                blueSize = i+1;
            if(redPosition[i].x != -1 && redPosition[i].y != -1)
                redSize = i+1;
        }
        
        if(blueSize == -1) return redSize;
        if(redSize == -1) return blueSize;
        
        int size = Math.max(blueSize, redSize);
        
        int bx = 0;
        int by = 0;
        int rx = 0;
        int ry = 0;
        
        for(int i = 0; i < size; i++){
            if(blueSize - 1 >= i){
                bx = bluePosition[i].x;
                by = bluePosition[i].y;
            }
            if(redSize - 1 >= i){
                rx = redPosition[i].x;
                ry = redPosition[i].y;
            }

            if(bx == rx && by == ry) return Integer.MAX_VALUE;
            if(i > 0){
                if(bx == redPosition[i-1].x && by == redPosition[i-1].y && rx == bluePosition[i-1].x && ry == bluePosition[i-1].y) return Integer.MAX_VALUE; 
            }
            else{
                if(bx == startRedX && by == startRedY && rx == startBlueX && ry == startBlueY) return Integer.MAX_VALUE;
            }
        }
        
        return size;
    }

    private boolean canMove(int[][] maze, boolean[][] move, int x, int y){
        if(x < 0 || x >= height || y < 0 || y >= width) return false;
        if(move[x][y] || maze[x][y] == 5) return false; 
        
        return true;
    }
    
    class Position{
        int x;
        int y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}