class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int size = queries.length;
        int [] answer = new int[size];
        int map[][] = new int[rows+1][columns+1];
        int index = 0;
        
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                index++;
                map[i][j] = index;
            }
        }
        
        for(int i = 0; i < size; i++){
            int startY = queries[i][0];
            int startX = queries[i][1];
            int endY = queries[i][2];
            int endX = queries[i][3];
            int firstNum = map[startY][endX];
            int min = firstNum;
            
            for(int j = endX-1; j >= startX; j--){
                min = Math.min(min, map[startY][j]);
                map[startY][j+1] = map[startY][j];
            }
            
            for(int j = startY+1; j <= endY; j++){
                min = Math.min(min, map[j][startX]);
                map[j-1][startX] = map[j][startX];
            }
            
            for(int j = startX+1; j <= endX; j++){
                min = Math.min(min, map[endY][j]);
                map[endY][j-1] = map[endY][j]; 
            }
            
            for(int j = endY-1; j >= startY; j--){
                min = Math.min(min, map[j][endX]);
                map[j+1][endX] = map[j][endX];
            }
            
            map[startY+1][endX] = firstNum;
            answer[i] = min;
        }
        return answer;
    }
}