import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        while(true){
            String password = br.readLine();

            if(password.equals("end")) break;

            char[] passChar = password.toCharArray();

            boolean firstCheck = false;
            boolean secondCheck = false;
            boolean thirdCheck = false;

            for(int i = 0; i < passChar.length; i++){
                secondCheck = false;

                if(vowel.contains(passChar[i])){
                    firstCheck = true;

                    for(int j = i+1; j < i+3; j++){
                        if(j >= passChar.length){
                            secondCheck = true;
                            break;
                        }
                        if(!vowel.contains(passChar[j]))
                            secondCheck = true;
                    }

                    if(!secondCheck){
                        System.out.println("<" + password + "> " + "is not acceptable.");
                        break;
                    }

                    secondCheck = false;
                }


                if(!vowel.contains(passChar[i])){
                    for(int j = i+1; j < i+3; j++){
                        if(j >= passChar.length){
                            secondCheck = true;
                            break;
                        }
                        if(vowel.contains(passChar[j])) {
                            secondCheck = true;
                        }
                    }

                    if(!secondCheck){
                        System.out.println("<" + password + "> " + "is not acceptable.");
                        break;
                    }
                }

                secondCheck = true;

                if(i+1 == passChar.length){
                    thirdCheck = true;
                    break;
                }

                if((passChar[i+1] == passChar[i]) && passChar[i] != 'e' && passChar[i] != 'o'){
                    System.out.println("<" + password + "> " + "is not acceptable.");
                    break;
                }

            }

            if(firstCheck && secondCheck && thirdCheck)
                System.out.println("<" + password + "> " + "is acceptable.");

            if(!firstCheck && secondCheck && thirdCheck){
                System.out.println("<" + password + "> " + "is not acceptable.");
            }
        }
    }

}
