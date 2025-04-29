import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        ArrayList<Integer> countList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= cards.length; i++){
            list.add(new ArrayList());
        }
        
        boolean[] visit = new boolean[cards.length];
        
        for(int i = 0; i < cards.length; i++){
            if(visit[i]) continue;
            
            int index = cards[i] - 1;
            list.get(i+1).add(i+1);
            visit[i] = true;
            int count = 1;
            while(true){
                if(visit[index]) break;
                
                count++;
                if(!visit[index]){
                    visit[index] = true;
                    list.get(i+1).add(index+1);
                    index = cards[index] - 1;
                }
            }
            
            countList.add(count);
        }
        
        Collections.sort(countList, Collections.reverseOrder());
        
        if(countList.size() == 1) return 0;
        
        answer = countList.get(0) * countList.get(1);
        
        return answer;
    }
}