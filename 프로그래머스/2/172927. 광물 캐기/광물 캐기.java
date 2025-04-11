import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] count = new int[minerals.length / 5 + 1][3];
        int max = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        int dia = 0;
        int iron = 0;
        int stone = 0;
        
        for(int i = 0; i < minerals.length; i += 5){
            if(i / 5 == max) break;
            for(int j = i; j < i+5; j++){
                
                if(minerals[j].charAt(0) == 'd'){
                    dia += 1;
                    iron += 5;
                    stone += 25;
                }
                else if(minerals[j].charAt(0) == 'i'){
                    dia += 1;
                    iron += 1;
                    stone += 5;
                }
                else{
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
                
                if(j == minerals.length - 1)
                    break;
            }
            count[i/5][0] = dia;
            count[i/5][1] = iron;
            count[i/5][2] = stone;
            
            dia = 0;
            iron = 0;
            stone = 0;
        }
        
        Arrays.sort(count, (o1, o2) -> o2[2] - o1[2]);
        
        for(int i = 0; i < max; i++){
            if(picks[0] > 0){
                answer += count[i][0];
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += count[i][1];
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += count[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }

}