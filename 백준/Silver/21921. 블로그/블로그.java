import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visitor = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < x; i++) sum += visitor[i];

        int max = sum;
        int count = 1;

        for (int i = x; i < n; i++) {
            sum += visitor[i] - visitor[i - x];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
