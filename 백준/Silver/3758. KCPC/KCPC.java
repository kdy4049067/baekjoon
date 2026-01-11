import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            int problem = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int log = Integer.parseInt(st.nextToken());

            int[][] result = new int[team+1][4];
            Integer[][] maxScore = new Integer[team+1][problem+1];

            result[0][0] = -1;

            for(int j = 0; j < log; j++){
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(maxScore[teamId][problemId] != null){
                    if(maxScore[teamId][problemId] < score){
                        result[teamId][1] += score - maxScore[teamId][problemId];
                        maxScore[teamId][problemId] = score;
                    }
                }
                else {
                    maxScore[teamId][problemId] = score;
                    result[teamId][1] += score;
                }

                result[teamId][3] = teamId;
                result[teamId][0]++;
                result[teamId][2] = j;
            }

            Arrays.sort(result, (int[] a, int[] b) ->{
                if(a[1] != b[1]) return b[1] - a[1];
                if(a[0] != b[0]) return a[0] - b[0];

                return a[2] - b[2];
            });

            for(int j = 0; j < team; j++){
                if(result[j][3] == myTeamId){
                    System.out.println(j+1);
                    break;
                }
            }

        }
    }

}
