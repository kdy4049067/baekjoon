import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] set;
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        set = new int[n+1];
        for(int i = 1; i <= n; i++)
            set[i] = i;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int criteria = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(criteria == 0) {
                if(num1 == num2)
                    continue;
                union(num1, num2);
            }
            else {
                if(num1 == num2) {
                    System.out.println("yes");
                    continue;
                }
                if (find(num1) == find(num2))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }

    static int find(int num){
        if(set[num] == num)
            return num;
        return set[num] = find(set[num]);
    }

    static void union(int num1, int num2){
        num1 = find(num1);
        num2 = find(num2);
        if(num1 != num2)
            set[num2] = num1;
    }
}
