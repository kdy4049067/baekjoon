import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> st = new Stack<>();
		
		while(!line.equals(".")) {
			st = new Stack<>();
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(' || c == '[')
					st.push(c);
				
				if(c == ')') {
					if(st.isEmpty() || st.peek() != '(') {
						st.push(c);
						break;
					}
					else
						st.pop();
				}
				if(c == ']') {
					if(st.isEmpty() || st.peek() != '['){
							st.push(c);
							break;
					}
					if(st.peek() == '[')
						st.pop();					
				}
			}
			if(st.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
			
			line = br.readLine();
		}
	}
}