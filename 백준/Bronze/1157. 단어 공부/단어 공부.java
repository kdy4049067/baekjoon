import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);

            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }

        List<Character> keySet = new ArrayList<>(map.keySet());

        if(keySet.size() == 1){
            System.out.println(keySet.get(0));
            return;
        }
        
        keySet.sort((c1, c2) -> map.get(c2).compareTo(map.get(c1)));

        if(Objects.equals(map.get(keySet.get(0)), map.get(keySet.get(1)))){
            System.out.println("?");
            return;
        }

        System.out.println(keySet.get(0));

    }

}
