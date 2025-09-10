import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String[] wheel;
    private static final int right = 2;
    private static final int left = 6;
    private static boolean check[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheel = new String[4];

        for(int i = 0; i < 4; i++){
            wheel[i] = br.readLine();
        }

        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < test; i++){
            st = new StringTokenizer(br.readLine());

            check = new boolean[4];
            Queue<Integer> moveQ = new LinkedList<>();

            int selectWheel = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            moveQ.add(selectWheel);

            while(!moveQ.isEmpty()){
                int targetWheel = moveQ.poll();

                check[targetWheel] = true;

                if(targetWheel == 0) {
                    if (wheel[targetWheel].charAt(right) != wheel[targetWheel + 1].charAt(left) && !check[targetWheel+1]) {
                        moveQ.add(targetWheel + 1);
                    }
                }

                else if(targetWheel == 3){
                    if (wheel[targetWheel].charAt(left) != wheel[targetWheel - 1].charAt(right) && !check[targetWheel-1]) {
                        moveQ.add(targetWheel - 1);
                    }
                }
                else{
                    if (wheel[targetWheel].charAt(right) != wheel[targetWheel + 1].charAt(left) && !check[targetWheel+1]) {
                        moveQ.add(targetWheel + 1);
                    }
                    if (wheel[targetWheel].charAt(left) != wheel[targetWheel - 1].charAt(right) && !check[targetWheel-1]) {
                        moveQ.add(targetWheel - 1);
                    }
                }
            }

            for(int j = 0; j < 4; j++){
                boolean b = Math.abs(selectWheel - j) % 2 == 0;

                if(dir == 1) {
                    if (check[j]) {
                        if (b) {
                            rotateClock(j);
                        }
                        else
                            rotateCounterClock(j);
                    }
                }
                else{
                    if (check[j]) {
                        if (b) {
                            rotateCounterClock(j);
                        }
                        else
                            rotateClock(j);
                    }
                }
            }
        }

        int score = 0;

        if(wheel[0].charAt(0) == '1') score++;
        if(wheel[1].charAt(0) == '1') score += 2;
        if(wheel[2].charAt(0) == '1') score += 4;
        if(wheel[3].charAt(0) == '1') score += 8;

        System.out.println(score);
    }

    private static void rotateClock(int select){
        char last = wheel[select].charAt(7);
        String moveWheel = wheel[select].substring(0, 7);

        wheel[select] = last + moveWheel;
    }

    private static void rotateCounterClock(int select){
        char first = wheel[select].charAt(0);
        String moveWheel = wheel[select].substring(1);

        wheel[select] = moveWheel + first;
    }

}
