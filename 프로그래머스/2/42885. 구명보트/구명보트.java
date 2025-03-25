import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        
        Arrays.sort(people);
        for(int i = people.length - 1; i >= start; i--){
            if(people[i] + people[start] <= limit){
                answer++;
                start++;
            }
            else{
                answer++;
            }
        }
        
        return answer;
    }
}