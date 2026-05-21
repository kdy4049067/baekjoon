class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        
        int[][] arr = new int[(n-1)/w+1][w];
        int start = 1;
        boolean toggle = true;
        
        for(int i = arr.length-1; i >= 0; i--){
            if(!toggle){
                for(int j = w-1; j >= 0; j--){
                    arr[i][j] = start++;
                }
                toggle = true;
            }
            else{
                for(int j = 0; j < w; j++){
                    arr[i][j] = start++; 
                }
                toggle = false;
            }
        }
        
        int col = 0;
        int row = 0;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < w; j++){
                if(arr[i][j] == num){
                    col = i;
                    row = j;
                }
            }
        }
        
        while(true){
            if(col-1 < 0) break;
            if(arr[col-1][row] > n) break;
            answer++;
            col -= 1;
        }
        
        return answer;
    }
}