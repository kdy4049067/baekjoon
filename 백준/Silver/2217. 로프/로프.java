import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int rope[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			rope = new int[n];
			int max = 0;
			
			for(int i = 0; i < n; i++) {
				rope[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(rope);
			
			for(int i = 0; i < rope.length; i++) {
				int result = ro(i, i);
				max = Math.max(max, result);
			}
			System.out.println(max);
	}
	
	static int ro(int index, int minus) {
		if(rope[index] * (rope.length - minus) < rope[rope.length-minus -1]) {
			return rope[rope.length-minus -1];
		}
		else
			return rope[index] * (rope.length - minus);
	}

}