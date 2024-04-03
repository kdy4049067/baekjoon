import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < size; i++){
            queue.add(s.nextInt());
        }
        int result = 0;
        while(queue.size() > 1){
            int card1 = queue.poll();
            int card2 = queue.poll();
            int plus = card1 + card2;
            result += plus;
            queue.add(plus);
        }
        System.out.println(result);
    }
}
