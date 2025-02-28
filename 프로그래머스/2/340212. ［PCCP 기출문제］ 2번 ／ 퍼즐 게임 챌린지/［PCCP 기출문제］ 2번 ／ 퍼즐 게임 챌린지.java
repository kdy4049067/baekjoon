import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int mid = 0;
        while(left < right){
            answer = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < diffs.length; i++){
                int leveldiff = diffs[i] - mid;
                if(leveldiff <= 0){
                    answer += times[i];
                }
                else{
                    int preTime = i == 0 ? 0 : times[i-1];
                    int nowTime = times[i];
                    int plus = (preTime + nowTime) * leveldiff + nowTime;
                    answer += plus;
                }
            }
            if(answer <= limit){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return right;
    }
}
