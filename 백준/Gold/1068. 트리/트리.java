import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> list;
    private static int remove;
    private static int[] result;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        result = new int[size];

        for(int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        int sizeOfNode = 0;

        for(int i = 0; i < size; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }
            list.get(parent).add(i);
        }

        remove = Integer.parseInt(br.readLine());
        dfs(root);

        System.out.println(result[root]);
    }

    private static int dfs(int root){
        if(root == remove) return 0;
        if(list.get(root).isEmpty()) return 1;

        for(int next : list.get(root)){
            if(next == remove){
                if(list.get(root).size() == 1){
                    result[root]++;
                }
            }
            result[root] += dfs(next);
        }

        return result[root];
    }

}
