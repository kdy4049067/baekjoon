import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();

        Queue<Long> q = new LinkedList<>();
        q.add(a);
        int count = 0;

        while(!q.isEmpty()) {
             int size = q.size();
             for(int i = 0; i < size; i++) {
                 long tmp = q.poll();
                 if (tmp == b) {
                     System.out.println(count + 1);
                     return;
                 }

                 if (tmp * 2 <= b) q.add(tmp * 2);
                 if (tmp * 10 + 1 <= b) q.add(tmp * 10 + 1);
             }
             count++;

        }
        System.out.println(-1);
    }
}

