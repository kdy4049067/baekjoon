import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        int size = 0;

        for(int i = 0; i < players.length; i++){
            while(!q.isEmpty() && q.peek()[0] == i){
                size -= q.poll()[1];

            }
            int need = players[i] / m;
            int more = size - need;
            if(more < 0){
                more = Math.abs(more);
                size += more;
                answer += more;
                q.add(new int[]{i+k, more});
            }
        }
        return answer;
    }
}
