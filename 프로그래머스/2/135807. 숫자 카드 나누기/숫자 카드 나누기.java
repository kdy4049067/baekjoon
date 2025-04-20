import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcd = getGcd(arrayA);
        int gcd2 = getGcd(arrayB);
        
        if(notDivisible(arrayA, gcd2)){
            if(answer < gcd2) answer = gcd2;
        }
        if(notDivisible(arrayB, gcd)){
            if(answer < gcd) answer = gcd;
        }
        
        return answer;
        
    }
    
    public int getGcd(int[] array){
        int gcd = array[0];
        
        for(int i = 1; i < array.length; i++){
            gcd = gcd(gcd, array[i]);
        }
        
        return gcd;
    }
    
    public int gcd(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        }
        else{
            return gcd(num2, num1 % num2);
        }
    }
    
        public boolean notDivisible(int[] arr, int num){
        for(int n : arr)
            if(n % num == 0)
                return false;
        return true;
    }
    
}