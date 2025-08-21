import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] rect;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long result = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            rect = new int[n];

            if(n == 0) break;

            for (int i = 0; i < n; i++) {
                rect[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(area(n));

        }

    }

    private static long area(int len){
        Stack<Integer> stack = new Stack<>();

        long max = 0;

        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && rect[stack.peek()] >= rect[i]){
                int height = rect[stack.pop()];
                long width = stack.isEmpty() ? i : i -1 - stack.peek();

                max = Math.max(max, height * width);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = rect[stack.pop()];

            long width = stack.isEmpty() ? len : len - stack.peek() - 1;
            max = Math.max(max, height * width);
        }

        return max;
    }

}
