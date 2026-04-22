import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        Set<String> set = new HashSet<>();
        ArrayList<int[]> record = new ArrayList<>();
        
        int recordStart = 0;
        
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) == ' '){
                if (recordStart <= i - 1) { 
                    record.add(new int[]{recordStart, i-1});
                }
                recordStart = i+1;
            }
        }
        
        if (recordStart <= message.length() - 1) {
            record.add(new int[]{recordStart, message.length()-1});
        }
        
        for(int i = 0; i < record.size(); i++){
            int[] r = record.get(i);
            int s = r[0];
            int e = r[1];
            boolean check = false;
            for(int j = 0; j < spoiler_ranges.length; j++){
                int start = spoiler_ranges[j][0];
                int end = spoiler_ranges[j][1];
                
                if((s <= start && start <= e) || (s <= end && end <= e) || (start <= s && e <= end)) check = true;
            }
            
            if(!check) set.add(message.substring(s, e+1));
        }
        
        for(int i = 0; i < spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            
            for(int j = 0; j < record.size(); j++){
                int[] r = record.get(j);
                int s = r[0];
                int e = r[1];
                
                if((s <= start && start <= e) || (s <= end && end <= e) || (start <= s && e <= end)){
                    String sub = message.substring(s, e+1);
                    if(set.contains(sub)){
                        continue;
                    }
                    else{
                        answer++;
                        set.add(sub);
                    }
                }
            }
        }
        
        return answer;
    }
}