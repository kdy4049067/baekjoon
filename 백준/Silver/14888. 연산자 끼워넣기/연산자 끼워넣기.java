import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] numberSet;
    static int[] op;
    static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());

        op = new int[4];
        numberSet = new int[number];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < number; i++) {
            numberSet[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numberSet[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int index){
        if(index == number){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;

                if(i == 0){
                    dfs(num + numberSet[index], index+1);
                }
                if(i == 1){
                    dfs(num - numberSet[index], index+1);
                }
                if(i == 2){
                    dfs(num * numberSet[index], index+1);
                }
                if(i == 3){
                    dfs(num / numberSet[index], index+1);
                }

                op[i]++;
            }
        }
    }

}
