class Solution {
    
    private boolean check = false;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            check = true;
            long num = numbers[i];
            String stringNum = Long.toBinaryString(num);
            
            int index = 1;
            int len = stringNum.length();
            
            while(index <= len){
                index = index * 2;
            }
            
            int diff = (index-1) - len;
            
            for(int j = 0; j < diff; j++){
                stringNum = String.valueOf(0) + stringNum;
            }
            
            divide(stringNum);
            answer[i] = check ? 1 : 0;
        }
        
        return answer;
    }
    
    private void divide(String str){
        if(str.length() < 3) return;
        
        int mid = str.length() / 2;
        
        if(str.charAt(mid) == '0'){
            for(int i = 1; i <= mid; i++){
                if(str.charAt(mid-i) != '0' || str.charAt(mid+i) != '0'){
                    check = false;
                    return;
                }
            }

        }
        
        String prevStr = str.substring(0, mid);
        String nextStr = str.substring(mid+1, str.length());
        
        divide(prevStr);
        divide(nextStr);
        
        return;
    }
}