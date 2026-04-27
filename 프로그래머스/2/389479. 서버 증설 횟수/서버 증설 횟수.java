class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] time = new int[25];
        
        for(int i = 0; i < players.length; i++){
            int num = players[i];
            int server = num / m;
            
            if(server < 1) continue;
            if(time[i] >= server) continue;
            
            int add = server - time[i];
            answer += add;
            
            for(int j = i; j < i+k; j++){
                if(j >= 25) break;
                time[j] += add;
            }
            
        }
        
        return answer;
    }
}