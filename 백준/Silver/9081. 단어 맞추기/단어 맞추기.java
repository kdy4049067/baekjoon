import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String word = br.readLine();
            char[] words = word.toCharArray();
            char[] result = comb(words);

            for(char c : result){
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static char[] comb(char[] words){
        int min = 0;
        int minIndex = -1;

        for(int i = words.length-1; i > 0; i--){
            char cur = words[i];
            char prev = words[i-1];

            if(cur > prev){
                min = prev;
                minIndex = i-1;
                break;
            }
        }

        if(minIndex == -1){
            return words;
        }

        int maxIndex = 0;

        for(int i = words.length-1; i >= 0; i--){
            if(words[i] > min){
                maxIndex = i;
                break;
            }
        }

        char temp = words[minIndex];
        words[minIndex] = words[maxIndex];
        words[maxIndex] = temp;

        Arrays.sort(words, minIndex+1, words.length);

        return words;
    }


}
