class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int moveH = h + dx[i];
            int moveW = w + dy[i];
            
            if(moveH < 0 || moveH >= board.length || moveW < 0 || moveW >= board[0].length) continue;
            
            if(board[moveH][moveW].equals(color)) answer++;
        }
        return answer;
    }
}