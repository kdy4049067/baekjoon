import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//시간 초과 발생 코드 : 100000까지 scoreList가 가질 수 있는데 for문으로 두 번 반복했기 때문에 시간초과 난다고 생각함.
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < test; i++){
            int peopleNum = Integer.parseInt(br.readLine());
            int result = peopleNum;
            ArrayList<Score> scoreList = new ArrayList<>();

            for(int j = 0; j < peopleNum; j++){
                st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                scoreList.add(new Score(score1,score2));
            }
            Collections.sort(scoreList);
            int criteria = scoreList.get(0).score2;
            for(int j = 1; j < scoreList.size(); j++){
                if(scoreList.get(j).score2 < criteria){
                    criteria = scoreList.get(j).score2;
                }
                else
                    result--;
            }
            System.out.println(result);
        }

    }
    public static class Score implements Comparable<Score>{
        int score1;
        int score2;
        public Score(int score1, int score2){
            this.score1 = score1;
            this.score2 = score2;
        }
        public int compareTo(Score s) {
            return this.score1 - s.score1;
        }
    }
}

