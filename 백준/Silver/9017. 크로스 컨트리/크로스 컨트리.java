import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n];
            ArrayList<Integer> banned = new ArrayList<>();
            ArrayList<int[]> sum = new ArrayList<>();
            int[] fifth = new int[201];
            int[] result = new int[201];

            HashMap<Integer, Integer> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int team = Integer.parseInt(st.nextToken());
                rank[j] = team;

                map.put(team, map.getOrDefault(team, 0) + 1);
            }

            for(int key : map.keySet()){
                if(map.get(key) < 6){
                    banned.add(key);
                }
            }

            int score = 1;

            for(int j = 0; j < n; j++){
                int team = rank[j];

                if(banned.contains(team)) continue;

                sum.add(new int[]{team, score++});
            }

            Collections.sort(sum, (int[] o1, int[] o2)->{
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            });

            int count = 0;
            int prev = 0;
            for(int j = 0; j < sum.size(); j++){
                int[] info = sum.get(j);

                int team = info[0];

                if(prev == team) continue;

                int rk = info[1];

                result[team] += rk;
                count++;

                if(count == 4){
                    count = 0;
                    prev = team;
                    fifth[team] = sum.get(j+1)[1];
                }
            }

            int answer = 0;
            int min = Integer.MAX_VALUE;
            int prevIndex = 0;

            for(int j = 1; j <= 200; j++){
                if(result[j] < min && result[j] != 0){
                    min = result[j];
                    answer = j;
                    prevIndex = j;
                }

                else if(result[j] == min){
                    if(fifth[prevIndex] > fifth[j])
                        answer = j;
                    else answer = prevIndex;
                }
            }

            System.out.println(answer);
        }
    }

}
