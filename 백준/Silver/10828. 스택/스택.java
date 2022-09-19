import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> stack = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			if(st.countTokens()==2) {
				st.nextToken();
				push(Integer.parseInt(st.nextToken()));
			}
			else {
				String command = st.nextToken();
				
				if(command.equals("pop")) pop();
				else if(command.equals("size")) size();
				else if(command.equals("empty")) empty();
				else if(command.equals("top")) top();
			}
			
		}
	}
	
	static void push(int x) {
		stack.add(x);
		return;
	}
	
	static void pop() {
		if(stack.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(stack.get(stack.size()-1));
		stack.remove(stack.size()-1);
		return;
	}
	
	static void size() {
		System.out.println(stack.size());
		return;
	}
	
	static void empty() {
		if(stack.isEmpty()) {
			System.out.println(1);
			return;
		}
		System.out.println(0);
		return;
	}
	
	static void top() {
		if(stack.isEmpty()) {
			System.out.println(-1);
			return;
		}
		System.out.println(stack.get(stack.size()-1));
		return;
	}
}
