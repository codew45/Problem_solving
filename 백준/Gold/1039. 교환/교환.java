import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int K;
	static int max = -1;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[1000001][K+1];
		
		bfs(new Pair(N, 0));
		System.out.println(max);
	}
	
	public static void bfs(Pair start) {
		Queue<Pair> q = new ArrayDeque<>();
		visited[start.num][0] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			if(cur.cnt==K) {
				max = Math.max(max, cur.num);
				continue;
			}
			
			int len = String.valueOf(N).length();
			
			for(int i=0;i<len-1;i++) {
				for(int j=i+1;j<len;j++) {
					String swapped = swap(cur.num, i,j);
					int swappedNum = Integer.parseInt(swapped);
					if(swapped.charAt(0)=='0' || visited[swappedNum][cur.cnt+1]) {
						continue;
					}
					visited[swappedNum][cur.cnt+1] = true;
					q.add(new Pair(swappedNum, cur.cnt+1));
				}
			}
		}
		
	}
	
	public static String swap(int num, int i, int j) {
		char[] arr = String.valueOf(num).toCharArray();
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return String.valueOf(arr);
	}
	
	static class Pair{
		int num;
		int cnt;

		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
	}

}
