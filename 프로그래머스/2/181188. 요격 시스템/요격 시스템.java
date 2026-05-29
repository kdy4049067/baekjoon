import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (int[] o1, int[] o2) ->{
            return o1[1] - o2[1];
        });
            
        for(int i = 0; i < targets.length; i++){
            int target = i;
            if(target == targets.length-1){
                answer++;
                break;
            }
            while(true){
                if(targets[i+1][0] < targets[target][1]){
                    i++;
                    if(i == targets.length-1){ 
                        answer++;
                        break;
                    }
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}