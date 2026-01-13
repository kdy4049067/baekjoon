import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String word = br.readLine();

        int result = 0;

        for(int i = 0; i <= str.length()-word.length(); i++){
            if(str.charAt(i) == word.charAt(0)){
                boolean check = true;
                for(int j = 0; j < word.length(); j++){
                    if(str.charAt(j+i) != word.charAt(j)){
                        check = false;
                        break;
                    }
                }

                if(check){
                    result++;
                    i += word.length()-1;
                }
            }
        }

        System.out.println(result);
    }

}
