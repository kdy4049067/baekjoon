import java.util.*;

class Solution {

    private int[] info;
    private int[] opposite;
    private int[] temp;
    private int size = 0;
    private int index = 0;
    private int max = 0;
    private int[] tempAnswer;
    
    public int[] solution(int[][] dice) {
        tempAnswer = new int[dice.length/2];
        info = new int[dice.length/2];
        opposite = new int[dice.length/2];
        size = (int)Math.pow(6, info.length);
        temp = new int[size];
        
        comb(0, 0, dice);
        return tempAnswer;
    }
    
    private void comb(int start, int depth, int[][] dice){
        if(depth == dice.length / 2){
            int in = 0;
            for(int i = 0; i < dice.length; i++){
                boolean include = false;
                for(int j = 0; j < info.length; j++){
                    if(info[j] == i) include = true;
                }
                if(!include){
                    opposite[in++] = i;
                }
            }
            index = 0;
            calculate(0, dice, info, 0);
            int[] aResult = temp.clone();

            index = 0;
            calculate(0, dice, opposite, 0);
            int[] bResult = temp.clone();
            
            int winCount = record(aResult, bResult);
            
            if(winCount > max){
                max = winCount;
                for(int i = 0; i < info.length; i++){
                    tempAnswer[i] = info[i] + 1;
                }
            }
            return;
        }
        
        for(int i = start; i < dice.length; i++){
            info[depth] = i;
            comb(i+1, depth+1, dice);
        }
    }
    
    private int record(int[] a, int[] b) {
        int result = 0;
        Arrays.sort(b); 

        for (int score : a) {
            result += countWinningGames(score, b);
        }
        return result;
    }

    private int countWinningGames(int score, int[] b) {
        int left = 0;
        int right = b.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (b[mid] < score) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private void calculate(int depth, int[][] dice, int[] arr, int currentSum){
        if(depth == arr.length){
            temp[index++] = currentSum;
            return;
        }
        
        int diceIdx = arr[depth];
            
        for (int i = 0; i < 6; i++) {
            calculate(depth + 1, dice, arr, currentSum + dice[diceIdx][i]);
        }
        
        return;
    }
}