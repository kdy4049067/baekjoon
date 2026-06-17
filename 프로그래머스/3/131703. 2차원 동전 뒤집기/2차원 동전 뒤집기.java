import java.util.*;

class Solution {

    private int[] arrWidth;
    private int[] arrHeight;
    private int answer;
    private int[][] currentMap;
    private int[][] targetMap;  

    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE; 
        targetMap = target;
        
        int rowLen = beginning.length;
        int colLen = beginning[0].length;
        
        currentMap = new int[rowLen][colLen];

        for (int i = 0; i <= rowLen; i++) {
            arrWidth = new int[i];
            widthDfs(beginning, 0, 0, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void flipRow(int r) {
        for (int c = 0; c < currentMap[0].length; c++) {
            currentMap[r][c] = currentMap[r][c] == 1 ? 0 : 1;
        }
    }

    private void flipCol(int c) {
        for (int r = 0; r < currentMap.length; r++) {
            currentMap[r][c] = currentMap[r][c] == 1 ? 0 : 1;
        }
    }

    private void widthDfs(int[][] beginning, int start, int depth, int limit) {
        if (depth == limit) {
            for (int j = 0; j <= beginning[0].length; j++) {
                arrHeight = new int[j];
                heightDfs(beginning, 0, 0, j);
            }
            return;
        }

        for (int i = start; i < beginning.length; i++) {
            arrWidth[depth] = i;
            widthDfs(beginning, i + 1, depth + 1, limit);
        }
    }

    private void heightDfs(int[][] beginning, int start, int depth, int limit) {
        if (depth == limit) {
            for (int i = 0; i < beginning.length; i++) {
                currentMap[i] = beginning[i].clone();
            }

            for (int r : arrWidth) {
                flipRow(r);
            }

            for (int c : arrHeight) {
                flipCol(c);
            }

            if (check()) {
                int currentFlipCount = arrWidth.length + arrHeight.length;
                answer = Math.min(answer, currentFlipCount);
            }
            return;
        }

        for (int i = start; i < beginning[0].length; i++) {
            arrHeight[depth] = i;
            heightDfs(beginning, i + 1, depth + 1, limit);
        }
    }

    private boolean check() {
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[i].length; j++) {
                if (currentMap[i][j] != targetMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}