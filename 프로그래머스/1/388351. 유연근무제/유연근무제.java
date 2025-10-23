import java.util.*;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private static final int WEEK_DAYS = 7;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i < schedules.length; i++){
            addQ(i, timelogs, startday);
            
            int max = pq.poll();
            int time = schedules[i] + 10;
            
            if(time % 100 >= 60){
                  time += 40;
            } 
            
            if(time >= max) answer++;
            
            pq.clear();
        }
        
        return answer;
    }
    
    private void addQ(int index, int[][] timelogs, int startday) {
        int day = startday;
        for (int i = 0; i < WEEK_DAYS; i++) {
            if (day != SATURDAY && day != SUNDAY) {
                pq.add(timelogs[index][i]);
            }
            day = day % 7 + 1;
        }   
    }
    
}