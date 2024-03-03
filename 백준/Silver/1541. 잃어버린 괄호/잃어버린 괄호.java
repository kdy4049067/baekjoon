import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] argr) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        String[] plusStr = str.split("-");
        for (int i = 0; i < plusStr.length; i++) {
            String[] ss = plusStr[i].split("\\+");
            if (i == 0) {
                for (String num : ss)
                    result += Integer.parseInt(num);
            } else
                for(String num : ss)
                    result -= Integer.parseInt(num);
        }
        System.out.println(result);
    }

}