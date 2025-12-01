import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int[] basket;
    private static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        basket = new int[m+1];

        for(int i = 1; i <= m; i++){
            basket[i] = i;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            change(start, end);
        }

        for(int i = 1; i <= m; i++){
            System.out.printf(basket[i] + " ");
        }
    }

    private static void change(int start, int end) {
        for (int i = start; i <= end; i++) {
            st.push(basket[i]);
        }

        for(int i = start; i <= end; i++){
            basket[i] = st.pop();
        }
    }

}
