class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_length = parseToTime(video_len);
        int current_pos = parseToTime(pos);
        int opening_start = parseToTime(op_start);
        int opening_end = parseToTime(op_end);

        for(int i = 0; i < commands.length; i++){
            current_pos = opening(current_pos, opening_start, opening_end);
            
            if(commands[i].equals("next")){
                current_pos += 10;
                
                if(current_pos > video_length) current_pos = video_length;
            }
            
            else if(commands[i].equals("prev")){
                current_pos -= 10;
                
                if(current_pos < 0) current_pos = 0;
            }
        }
        
        current_pos = opening(current_pos, opening_start, opening_end);
        
        int minute = current_pos / 60;
        int second = current_pos % 60;
        
        if(minute < 10) answer += "0" + String.valueOf(minute);
        else answer += minute;
        
        answer += ":";
        
        if(second < 10) answer += "0" + String.valueOf(second);
        else answer += second;
        
        return answer;
    }
    
    private int parseToTime(String stringTime){
        String[] splitTime = stringTime.split(":");
        
        int minute = Integer.parseInt(splitTime[0]);
        int second = Integer.parseInt(splitTime[1]);
        
        return minute * 60 + second;
    }
    
    private int opening(int currentPos, int op_start, int op_end){
        if(currentPos >= op_start && currentPos <= op_end)
            return op_end;
        
        return currentPos;
    }
        
}