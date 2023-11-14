import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kg = Integer.parseInt(br.readLine());
		int kg5 = kg / 5;
		int kg3 = 0;
		
		for(int i = kg5; i > 0; i--) {
			if((kg - i * 5) % 3 == 0) {
				kg3 = (kg - i * 5) / 3;
				System.out.println(kg3+i);
				return;
			}
			if(i == 1) {
				if(kg % 3 == 0) {
					System.out.println(kg / 3);
					return;
				}
			}
		}
		if(kg <5) {
			if(kg == 3) {
				System.out.println(1);
				return;
			}
			System.out.println(-1);
            return;
		}
		System.out.println(-1);
		
	}

}