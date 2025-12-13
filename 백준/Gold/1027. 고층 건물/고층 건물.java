import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] building = new int[n];

        for(int i = 0; i < n; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int visible = 0;

            double maxSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                double slope = (double)(building[j] - building[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    visible++;
                }
            }

            double minSlope = Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(building[j] - building[i]) / (j - i);
                if (slope < minSlope) {
                    minSlope = slope;
                    visible++;
                }
            }

            count = Math.max(count, visible);
        }

        System.out.println(count);
    }

}
