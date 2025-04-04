class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String number = "";
        
        for(int i = 0; i < m * t; i++){
            if(number.length() > m * t)
                break;
            String num = Integer.toString(i, n).toUpperCase();
            number += num;
        }
        
        for(int i = 0; i < t; i++){
            int index = i * m + (p-1);
            answer += number.charAt(index) + "";
        }
        
        return answer;
    }
}