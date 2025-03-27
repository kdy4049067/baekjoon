import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < prices.length; i++){
            q.add(prices[i]);
        }
        
        int index = 0;
        while(!q.isEmpty()){
            int price = q.poll();
            int count = 0;
            for(int i = prices.length - q.size(); i < prices.length; i++){
                if(prices[i] < price){
                    answer[index]++;
                    break;
                }
                if(prices[i] >= price){
                    answer[index]++;
                }
            }
            index++;
        }

        return answer;
    }
}