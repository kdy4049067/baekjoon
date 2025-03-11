import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        int size = queue1.length;
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < size; i++){
            long number1 = queue1[i];
            long number2 = queue2[i];
            sum1 += number1;
            sum2 += number2;
            q1.add(number1);
            q2.add(number2);
        }
        sum = sum1 + sum2;
        long target = sum / 2;

        if(sum % 2 != 0) return -1;
        
        while(sum1 != target){
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            if(sum1 > target){
                long p1 = q1.poll();
                sum1 -= p1;
                sum2 += p1;
                q2.add(p1);
                answer++;
            }
            
            if(sum2 > target){
                long p2 = q2.poll();
                sum1 += p2;
                sum2 -= p2;
                q1.add(p2);
                answer++;
            }
            
            if(q1.isEmpty() || q2.isEmpty()) return -1;
        }
        
        return answer;
    }
}