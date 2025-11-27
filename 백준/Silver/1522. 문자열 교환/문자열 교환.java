import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        int bCount = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a') count++;
        }

        ArrayList<Character> list;

        for(int i = 0; i < str.length(); i++) {
            bCount = 0;
            list = new ArrayList<>();
            for(int j = i; j < i + count; j++){
                int index = j % str.length();
                list.add(str.charAt(index));
            }
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == 'b') bCount++;
            }

            min = Math.min(min, bCount);
        }

        System.out.println(min);
    }

}
