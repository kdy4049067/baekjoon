import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int len;
    private static int total;
    private static ArrayList<Character> list;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        len = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        char[] c = new char[total];
        for(int i = 0; i < total; i++){
            c[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(c);

        comb(c, 0, 0);
    }

    private static void comb(char[] c, int start, int depth){
        if(depth == len){
            isAvailable(list);
            return;
        }
        for(int i = start; i < total; i++){
            list.add(c[i]);
            comb(c, i+1, depth+1);
            list.remove(list.size()-1);
        }
    }

    private static void isAvailable(ArrayList<Character> list) {
        int countOfVowels = 0;
        int countOfConsonants = 0;

        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                countOfVowels++;
            else
                countOfConsonants++;
        }

        if (countOfVowels >= 1 && countOfConsonants >= 2) {
            for (int i = 0; i < len; i++) {
                System.out.printf(String.valueOf(list.get(i)));
            }
            System.out.println();
        }
    }

}
