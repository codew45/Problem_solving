import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			while(num<=input) {
				stack.push(num++);
				sb.append("+\n");
			}
			if(stack.peek()==input) {
				stack.pop();
				sb.append("-\n");
			}
		}
		if(!stack.isEmpty()) sb = new StringBuilder("NO");
		System.out.println(sb);
		
	}

}
