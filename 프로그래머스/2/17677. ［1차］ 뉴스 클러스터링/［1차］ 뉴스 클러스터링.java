import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = new ArrayList<>();
        List<String> s4 = new ArrayList<>();
        
        int answer = 0;
        
        for(int i = 0; i < str1.length() - 1; i++){
            boolean alpha = false;
            for(int j = i; j < i + 2; j++){
                char c = str1.charAt(j);
                if(!Character.isAlphabetic(c)){
                    alpha = true;
                    break;
                }
            }
            if(alpha) continue;
            s1.add(str1.substring(i, i+2).toLowerCase());
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            boolean alpha = false;
            for(int j = i; j < i + 2; j++){
                char c = str2.charAt(j);
                if(!Character.isAlphabetic(c)){
                    alpha = true;
                    break;
                }
            }
            if(alpha) continue;
            s2.add(str2.substring(i, i+2).toLowerCase());
        }
        
        
        for(String s : s1){
            if(s2.remove(s)){
                s3.add(s);
            }
            s4.add(s);
        }

        for(String s : s2){
            s4.add(s);
        }

        double a = s3.size();
        double b = s4.size();
        
        double jakard = 0;
        
        if(s4.size() == 0)
            jakard = 1;
        else
            jakard = (double) a / b;
        
        answer = (int) (jakard * 65536);
        return answer;
    }
}