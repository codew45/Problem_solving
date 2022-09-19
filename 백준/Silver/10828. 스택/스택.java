import java.io.*;
import java.util.*;

public class Main {
	static int[] stack;
	static int size = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				sb.append(pop()).append('\n');
				break;
				
			case "size":
				sb.append(size()).append('\n');
				break;
				
			case "empty":
				sb.append(empty()).append('\n');
				break;
				
			case "top":
				sb.append(top()).append('\n');
				break;
			}
			
		}
		System.out.println(sb);
	}
	
	static void push(int x) {
		stack[size] = x;
		size++;
		return;
	}
	
	static int pop() {
		if(size==0) {
			return -1;
		}
		
		int tmp = stack[size-1];
		stack[size-1] = 0;
		size--;
		return tmp;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size==0) {
			return 1;
		}
		return 0;
	}
	
	static int top() {
		if(empty()==1) {
			return -1;
		}
		return stack[size-1];
	}
}
