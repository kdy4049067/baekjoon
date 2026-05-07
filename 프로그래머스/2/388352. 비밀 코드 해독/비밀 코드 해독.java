class Solution {
    
    private int[] candidate;
    private int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        candidate = new int[5];
        dfs(n, 1, 0, q, ans);
        
        return answer;
    }
    
    private void dfs(int n, int start, int depth, int[][] q, int[] ans){
        if(depth == 5){
            if(simulate(q, ans)){
                answer++;
            }
            return;
        }
        
        for(int i = start; i <= n; i++){
            candidate[depth] = i;
            dfs(n, i+1, depth+1, q, ans);
        }
    }
    
    private boolean simulate(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int[] qq = q[i];
            int count = 0;
            for(int j = 0; j < qq.length; j++){
                for(int k = 0; k < qq.length; k++){
                    if(qq[j] == candidate[k]) count++;
                }
            }
            
            if(ans[i] != count) return false;
        }
        
        return true;
    }
}