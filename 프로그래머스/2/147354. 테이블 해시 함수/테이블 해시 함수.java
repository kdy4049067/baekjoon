import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (int[] o1, int[] o2) ->{
            if(o1[col-1] == o2[col-1]){
                return o2[0] - o1[0];
            } 
        
            return o1[col-1] - o2[col-1];
        });
        
        int[] hash = new int[row_end - row_begin + 1];
        int index = 0;
        
        for(int i = row_begin-1; i < row_end; i++){
            int sum = 0;
            for(int j = 0; j < data[0].length; j++){
                sum += data[i][j] % (i+1);
            }
                
            hash[index++] = sum;
        }
        
        for(int i = 0; i < hash.length; i++){
            answer = answer ^ hash[i];
        }
        
        return answer;
    }
}