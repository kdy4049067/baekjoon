import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int element = Integer.parseInt(br.readLine());
            if(element <= 0) minus.add(element);
            else plus.add(element);
        }

        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);

        int result = 0;

        for(int i = 0; i < plus.size(); i+=2){
            int cur = plus.get(i);
            if(i+1 >= plus.size()) break;

            int next = plus.get(i+1);

            if(next == 1){
                result += cur + next;
                continue;
            }
            result += cur * next;
        }

        if(plus.size() % 2 == 1) result += plus.get(plus.size()-1);

        for(int i = 0; i < minus.size(); i+=2){
            int cur = minus.get(i);

            if(i+1 >= minus.size()) break;
            int next = minus.get(i+1);

            if(cur == 0 || next == 0) break;

            result += cur * next;
        }

        if(minus.size() % 2 == 1) result += minus.get(minus.size()-1);

        System.out.println(result);
    }

}
