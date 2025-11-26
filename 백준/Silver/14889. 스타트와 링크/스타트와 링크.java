import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static boolean[] check;
    private static ArrayList<Integer> list;
    private static int[][] value;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        value = new int[n][n];
        check = new boolean[n];
        list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = n / 2;

        comb(0, 0);
        System.out.println(result);
    }

    private static void comb(int start, int depth){
        if(depth == n / 2){
            result = Math.min(result, Math.abs(calculate(divideTeam()) - calculate(list)));
            return;
        }

        for(int i = start; i < n; i++){
            if(!check[i]){
                list.add(i);
                check[i] = true;
                comb(i+1, depth+1);
                check[i] = false;
                list.remove(list.size() - 1);
            }
            else continue;
        }
    }

    private static ArrayList<Integer> divideTeam(){
        ArrayList<Integer> otherList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!list.contains(i)) otherList.add(i);
        }

        return otherList;
    }

    private static int calculate(ArrayList<Integer> list){
        int sum = 0;

        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
                int x = list.get(i);
                int y = list.get(j);

                sum += value[x][y] + value[y][x];
            }
        }

        return sum;
    }

}
