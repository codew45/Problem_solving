import java.io.*;
import java.util.*;

public class Main {
	static int size = 0;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			sb.append(solve(str)).append('\n');
			size = 0;
		}
		System.out.println(sb);
	}
	
	static void push(int[] stack, int n) {
		stack[size] = n;
		size++;
	}
	
	static boolean empty(int[] stack) {
		if(size==0) return true;
		return false;
	}
	static boolean pop(int[] stack) {
		if(size==0) {
			return false;
		}
		stack[size-1] = 0;
		size--;
		return true;
	}
	
	static String solve(String str) {
		int len = str.length();
		int[] stack = new int[len];
		
		for(int i=0;i<len;i++) {
			char c = str.charAt(i);
			
			if(c=='(') {
				push(stack, 1);
			}
			
			else if(empty(stack)) {
				return "NO";
			}
			
			else {
				pop(stack);
			}
		}
		if(empty(stack)) {
			return "YES";
		}
		else {
			return "NO";
		}
		
	}

}
