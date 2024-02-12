import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String target = br.readLine();
		
		int inputLen = input.length();
		int targetLen = target.length();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<inputLen;i++) {
			
			stack.push(input.charAt(i));
			
			boolean flag = true;
			
			if(stack.size()>=targetLen&&stack.peek()==target.charAt(targetLen-1)) {
				for(int j=0;j<targetLen;j++) {
					if(stack.get(stack.size()-j-1)!=target.charAt(targetLen-j-1)) {
						flag = false;
					}
				}
				if(flag) {
					for(int j=0;j<targetLen;j++) stack.pop();
				}
			}
			
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			while(!stack.isEmpty()) sb.append(stack.pop());
			System.out.println(sb.reverse());
		}
		
	}

}
