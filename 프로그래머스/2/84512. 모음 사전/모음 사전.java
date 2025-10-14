import java.util.*;

class Solution {
    
    int answer = 0;
    String[] chars = {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs("");
        
        for(int i = 0; i < list.size(); i++){
            if(word.equals(list.get(i))){
                answer = i;
            }
        }
        
        return answer;
    }
    
    private void dfs(String word){
        list.add(word);
        
        if(word.length() == 5)
            return;
        for(int i = 0; i < 5; i++){
            dfs(word + chars[i]);
        }
    }
    
}