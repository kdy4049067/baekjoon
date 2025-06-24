import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = s.nextInt();

        PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0; i < n; i++){
            int num = s.nextInt();

            if(minQ.size() == maxQ.size()) maxQ.offer(num);
            else minQ.offer(num);

            if(!minQ.isEmpty() && !maxQ.isEmpty()){
                if(maxQ.peek() > minQ.peek()){
                    int tmp = maxQ.poll();
                    maxQ.offer(minQ.poll());
                    minQ.offer(tmp);
                }
            }
            sb.append(maxQ.peek() + "\n");
        }

        System.out.println(sb.toString());
    }

}
