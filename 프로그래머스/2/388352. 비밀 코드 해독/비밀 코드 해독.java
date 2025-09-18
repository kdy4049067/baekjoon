class Solution {
    
    private static int Q_SIZE = 5;
    private static boolean[] visited;
    private static int result = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n+1];
        comb(n, q, ans, 1, 0);
        
        return result;
    }
    
    private void comb(int n, int[][] q, int[] ans, int index, int depth){
        if(depth == 5){
            for(int i = 0; i < q.length; i++){
                int count = 0;
                
                for(int j = 0; j < Q_SIZE; j++){
                    if(count > ans[i]) break;
                    if(visited[q[i][j]]) count++;
                }
                if(ans[i] != count) return;
            }
            
            result++;
            return;
        }
    
        
        for(int i = index; i <= n; i++){
            visited[i] = true;
            comb(n, q, ans, i+1, depth+1);
            visited[i] = false;
        }
    }
}
