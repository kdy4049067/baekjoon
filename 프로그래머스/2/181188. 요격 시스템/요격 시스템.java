import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int index = 0;
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        for(int i = 0; i < targets.length; i++){
            if(index <= targets[i][0]){
                index = targets[i][1];
                answer++;
            }

        }
        return answer;
    }
}