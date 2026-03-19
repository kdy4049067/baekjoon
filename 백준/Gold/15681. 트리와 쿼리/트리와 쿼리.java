import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> list;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        size = new int[n+1];
        list = new ArrayList<>();

        Arrays.fill(size, 1);

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        makeTree(r, -1);

        for(int i = 0; i < q; i++){
            int cur = Integer.parseInt(br.readLine());
            System.out.println(size[cur]);
        }
    }

    private static void makeTree(int cur, int parent){
        for(int nxt : list.get(cur)){
            if(parent != nxt){
                makeTree(nxt, cur);
            }
        }

        if(parent != -1){
            size[parent] += size[cur];
        }
    }

}
