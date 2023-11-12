import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Pair [] arr = new Pair[3];
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		double sum [] = new double[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		if((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[2].y - arr[1].y) * (arr[1].x - arr[0].x)) {
			System.out.println(-1.0);
		}
		
		else {
			double len1 = Math.sqrt(Math.pow(arr[0].x -arr[1].x,2) + Math.pow(arr[0].y - arr[1].y, 2)); 
			double len2 = Math.sqrt(Math.pow(arr[0].x -arr[2].x,2) + Math.pow(arr[0].y - arr[2].y, 2)); 
			double len3 = Math.sqrt(Math.pow(arr[1].x -arr[2].x,2) + Math.pow(arr[1].y - arr[2].y, 2)); 
		
			sum[0] = len1 + len2;
			sum[1] = len1 + len3;
			sum[2] = len2 + len3;
		
		
			for(int i = 0; i < 3; i++) {
				if(sum[i] < min)
					min = sum[i];
				if(sum[i] > max)
					max = sum[i];
			}
		
			System.out.println(max * 2 - min * 2);
		}
	}
	
	static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
