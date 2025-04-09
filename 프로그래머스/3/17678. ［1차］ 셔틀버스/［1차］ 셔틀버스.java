import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(String time : timetable){
            int ti = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
            q.add(ti);
        }
        
        int startTime = 9 * 60;
        int lastTime = 0;
        int total = 0;
        
        for(int i = 0; i < n; i++){
            total = 0;
            while(!q.isEmpty()){
                int current = q.peek();
                if(current <= startTime && total < m){
                    q.poll();
                    total++;
                }
                else break;
                lastTime = current - 1;
            }
            startTime += t;
        }
        
        if(total < m){
            lastTime = startTime - t;
        }
        
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        
        String answer = hour + ":" + minute;
        
        return answer;
    }
}