import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] check;
    private static ArrayList<ArrayList<Integer>> list;
    private static int[] result;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList<>();
        result = new int[size+1];
        check = new boolean[size+1];

        for(int i = 0; i <= size; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < size-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        dfs(1);

        for(int i = 2; i <= size; i++){
            System.out.println(result[i]);
        }
    }

    private static void dfs(int index){
        for(int next : list.get(index)){
            if(!check[next]){
                check[next] = true;
                result[next] = index;
                dfs(next);
            }
        }
    }

}
