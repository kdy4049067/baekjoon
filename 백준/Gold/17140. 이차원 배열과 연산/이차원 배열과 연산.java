import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int r, c, k;
    private static int[][] a = new int[101][101];
    private static int xLen = 3, yLen = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                int element = Integer.parseInt(st.nextToken());
                a[i][j] = element;
            }
        }

        System.out.println(sol());
    }

    public static class Pair implements Comparable<Pair>{
        @Override
        public int compareTo(Pair p){
            if(this.count == p.count){
                return this.number - p.number;
            }
            else if(this.count > p.count){
                return 1;
            }
            else return -1;
        }

        int number;
        int count;

        public Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    
    private static int sol(){
        for(int i = 0; i <= 100; i++){
            if(a[r][c] == k){
                return i;
            }
            
            cal();
        }
        
        return -1;
    }

    private static void cal(){
        if(xLen >= yLen){
            for(int i = 1; i <= xLen; i++){
                calRow(i);
            }
        }
        else{
            for(int i = 1; i <=yLen; i++){
                calCol(i);
            }
        }
    }

    private static void calRow(int index){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= yLen; i++){
            if(a[index][i] == 0) continue;
            map.compute(a[index][i], (key, value) -> (value == null) ? 1 : value + 1);
        }

        map.forEach((key, value) -> {
            pq.add(new Pair(key, value));
        });
        
        int max = 1;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            a[index][max++] = p.number;
            a[index][max++] = p.count;
        }
        
        yLen = Math.max(yLen, max);
        
        while(max <= 99){
            a[index][max++] = 0;
            a[index][max++] = 0;
        }
    }
    
    private static void calCol(int index){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= xLen; i++){
            if(a[i][index] == 0) continue;
            map.compute(a[i][index], (key, value) -> (value == null) ? 1 : value + 1);
        }

        map.forEach((key, value) ->{
            pq.add(new Pair(key, value));
        });
        
        int max = 1;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            a[max++][index] = p.number;
            a[max++][index] = p.count;
        }
        
        xLen = Math.max(xLen, max);
        
        while(max <= 99){
            a[max++][index] = 0;
            a[max++][index] = 0;
        }
    }

}
