import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length; j++){
                if(park[i][j].equals("-1")){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] position = q.poll();
            int x = position[0];
            int y = position[1];
            for(int k = 0; k < mats.length; k++){
                boolean check = false;
                for(int i = x; i < x + mats[k]; i++){
                    for(int j = y; j < y + mats[k]; j++){
                        if(i < 0 || i >= park.length || j < 0 || j >= park[i].length){
                            check  =true;
                            break;
                        }
                        if(!park[i][j].equals("-1")){
                            check = true;
                            break;
                        }
                    }
                }
                if(check == false) answer = Math.max(answer, mats[k]);
            }
        }
        return answer;
    }
}