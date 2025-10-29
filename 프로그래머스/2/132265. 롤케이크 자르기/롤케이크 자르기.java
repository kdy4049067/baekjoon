import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[][] dp = new int[topping.length][2];
        Set<Integer> firstSet = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < topping.length; i++){
            firstSet.add(topping[i]);
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            
            dp[i][0] = firstSet.size();
        }
        
        for(int i = 0; i < topping.length; i++){
            map.put(topping[i], map.get(topping[i]) - 1);
            
            if(map.get(topping[i]) == 0) map.remove(topping[i]);
            
            dp[i][1] = map.size();
        }
        
        for(int i = 0; i < topping.length; i++){
            if(dp[i][0] == dp[i][1])
                answer++;
        }
        
        return answer;
    }
}