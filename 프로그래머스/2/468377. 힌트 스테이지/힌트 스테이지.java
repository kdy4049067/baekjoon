class Solution {
    
    private int[] h;
    private int answer = Integer.MAX_VALUE;
    private int k;
    
    public int solution(int[][] cost, int[][] hint) {
        int temp = 0;
        for(int i = 1; i < cost.length; i++){
            temp += cost[i][0];
        }
        
        for(int i = 1; i <= hint.length; i++){
            h = new int[i];
            k = i;
            dfs(0, 0, cost, hint);
        }

        answer = Math.min(answer, temp);
        answer += cost[0][0];
        
        return answer;
    }
    
    private void dfs(int depth, int start, int[][] cost, int[][] hint){
        if(depth == k){
            answer = Math.min(answer, calculate(cost, hint));
            return;
        }
        
        for(int i = start; i < hint.length; i++){
            h[depth] = i;
            dfs(depth+1, i+1, cost, hint);
        }
    }
    
    private int calculate(int[][] cost, int[][] hint){
        int[] hintSum = new int[cost.length];
        int sum = 0;
        
        for(int i = 0; i < h.length; i++){
            int index = h[i];
            int[] info = hint[index];
            int c = info[0];
            sum += c;
            for(int j = 1; j < hint[i].length; j++){
                int hintStage = info[j] - 1;
                hintSum[hintStage]++;
            }
        }
        
        for(int i = 1; i < cost.length; i++){
            if(hintSum[i] >= cost.length){
                sum += cost[i][cost.length-1];
                continue;
            }
            sum += cost[i][hintSum[i]];
        }
        
        return sum;
    }
}