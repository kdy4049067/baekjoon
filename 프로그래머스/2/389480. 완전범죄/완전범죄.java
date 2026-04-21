import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
    
        Arrays.sort(info, (int[] o1, int[] o2)->{
            double ratio1 = (double) o2[0]/o2[1];
            double ratio2 = (double) o1[0]/o1[1];
            
            if(ratio1 == ratio2) return Double.compare(o2[0], o1[0]);
            else{
                return Double.compare(ratio1, ratio2);
            }
        });

        for(int i = 0; i < info.length; i++){
            int a = info[i][0];
            int b = info[i][1];
            
            if(m > b) m -= b;
            else if(n > a){
                n -= a;
                answer += a;
            }
            else{
                return -1;
            }
        }
        
        return answer;
    }
}