class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int time = bandage[0];
        int recovery = bandage[1];
        int extra = bandage[2];
        int current = 1;
        int currentHealth = health;
        
        for(int i = 0; i < attacks.length; i++){
            int sum = 0;
            int count = 0;
            int attackTime = attacks[i][0];
            int attack = attacks[i][1];
            
            for(int j = current; j < attackTime; j++){
                sum += recovery;
                count++;
                
                if(count == time){
                    sum += extra;
                    count = 0;
                }
            }    
            
            
            if(sum + currentHealth > health){
                currentHealth = health;
            }
            else{
                currentHealth += sum;
            }
            
            if(currentHealth - attack <= 0) return -1;
            
            currentHealth -= attack;
            
            current = attackTime + 1;
        }
        
        answer = currentHealth;
        
        return answer;
    }
    
}