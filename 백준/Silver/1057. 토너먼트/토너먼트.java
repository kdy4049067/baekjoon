import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int people = Integer.parseInt(st.nextToken());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		if(p1 % 2 == 1  && p2 == p1 + 1 || (p1 % 2 == 0 && p2 == p1 - 1)) {
			count++;
			System.out.println(count);
		}
		else {
			while(people != 0) {
				people /= 2;
			
				if(p1 % 2 == 0)
					p1 /= 2;
				else
					p1 = p1 / 2 + 1;
			
				if(p2 % 2 == 0)
					p2 /= 2;
				else
					p2 = p2 / 2 + 1;
			
				count++;
			
				if(p1 % 2 == 1  && p2 == p1 + 1 || (p1 % 2 == 0 && p2 == p1 - 1)) {
					count++;
					break;
				}
			}
			System.out.println(count);
		}
	}
}
