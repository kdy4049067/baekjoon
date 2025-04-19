import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++){
            String[] splitTime = book_time[i];
            String[] start = splitTime[0].split(":");
            String[] end = splitTime[1].split(":");
            
            int startHour = Integer.parseInt(start[0]);
            int startMinute = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMinute = Integer.parseInt(end[1]);
            
            int startTime = startHour * 60 + startMinute;
            int endTime = endHour * 60 + endMinute;
            
            time[i][0] = startTime;
            time[i][1] = endTime;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
           return o1[0] - o2[0]; 
        });
        
        PriorityQueue<Integer> endMin = new PriorityQueue<>();
        
        for(int i = 0; i < time.length; i++){
            pq.add(time[i]);
        }
        
        int room = 1;
        int[] first = pq.poll();
        
        int start = first[0];
        int end = first[1];
            
        endMin.add(end);
        
        while(!pq.isEmpty()){
            int t[] = pq.poll();
            int s = t[0];
            int e = t[1];
            
            if(s >= endMin.peek() + 10){
                endMin.poll();
            }
            else{
                room++;
            }
            
            endMin.add(e);
        }
        
        return room;
    }
    
}