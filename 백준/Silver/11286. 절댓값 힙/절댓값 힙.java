import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q_plus = new PriorityQueue<>();
        PriorityQueue<Integer> q_minus = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x > 0){
                q_plus.add(x);
            }
            else if(x < 0){
                q_minus.add(x);
            }
            else{
                if(q_plus.isEmpty() && !q_minus.isEmpty()) {
                    int result = q_minus.poll();
                    System.out.println(result);
                }
                else if(q_minus.isEmpty() && !q_plus.isEmpty()){
                    int result = q_plus.poll();
                    System.out.println(result);
                }
                else if(!q_minus.isEmpty() && !q_plus.isEmpty()){
                    if(Math.abs(q_minus.peek()) == Math.abs(q_plus.peek()))
                        System.out.println(q_minus.poll());
                    else{
                        if(Math.abs(q_minus.peek()) > Math.abs(q_plus.peek()))
                            System.out.println(q_plus.poll());
                        else
                            System.out.println(q_minus.poll());
                    }
                }
                else
                    System.out.println(0);
            }
        }
    }
}