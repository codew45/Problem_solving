import java.io.*;
import java.util.*;
public class Main {
	static int[] queue;
	static int head = 0;
	static int rear = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
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
			case "front":
				sb.append(front()).append('\n');
				break;
			case "back":
				sb.append(back()).append('\n');
				break;
				
			}
			
		}
		System.out.println(sb);
	}
	
	static void push(int n) {
		queue[rear] = n;
		rear++;
		return;
		
	}
	
	static int pop() {
		if(head==rear) return -1;
		
		int tmp = queue[head];
		head++;
		return tmp;
	}
	
	static int size() {
		return rear - head;
	}
	
	static int empty() {
		if(head==rear) return 1;
		else return 0;
	}
	static int front() {
		if(head==rear) return -1;
		return queue[head];
	}
	static int back() {
		if(head==rear) return -1;
		return queue[rear-1];
	}

}
