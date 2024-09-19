import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String end = st.nextToken();

        int count = 0;
        if(start.length() == end.length()) {
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == end.charAt(i)) {
                    if (start.charAt(i) == '8')
                        count++;
                }
                else
                    break;
            }
        }

        System.out.println(count);
    }
}