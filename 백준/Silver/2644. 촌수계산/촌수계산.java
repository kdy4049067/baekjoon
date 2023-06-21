import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> relation[];
	static int res = -1;
	static boolean[] checked;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		checked = new boolean[n+1];
		
		relation = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			relation[i] = new ArrayList<>();
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int re = Integer.parseInt(br.readLine());
		for(int i = 0; i < re; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			relation[parent].add(child);
			relation[child].add(parent);
		}
		
		recur(start, end, 0);
		System.out.println(res);
		
	}
	
	public static void recur(int x, int y, int n) {
		checked[x] = true;
		if(x == y) {
			res = n;
			return;
		}
		
		for(int i = 0; i < relation[x].size(); i++) {
			int next = relation[x].get(i);
			if(next == y) {
				res = ++n;
				return;
			
			}
			
			if(!checked[next])
				recur(next, y, n+1);
		}
	}
}
