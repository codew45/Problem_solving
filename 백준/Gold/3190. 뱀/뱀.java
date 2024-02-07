import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r-1][c-1] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		HashMap<Integer,String> move = new HashMap<>();
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		int time = 0;
		int dir = 3;
		arr[0][0] = -1;
		
		Queue<Node> snake = new ArrayDeque<>();
		snake.add(new Node(0,0));
		int headX = 0;
		int headY = 0;
		
		while(true) {
			String nextDir = move.get(time);
			if(nextDir!=null) {
				if(nextDir.equals("D")) dir = (dir+1)%4;
				else if (nextDir.equals("L")) dir = (dir+3)%4;
			}
			
			int nx = headX+dx[dir];
			int ny = headY+dy[dir];
			time++;
			if(0<=nx&&nx<N&&0<=ny&&ny<N) {
				if(arr[nx][ny]==-1) {
					System.out.println(time);
					break;
				}
				else {
					snake.add(new Node(nx,ny));
					headX = nx;
					headY = ny;
					
					if(arr[nx][ny]==0) {
						Node n = snake.poll();
						arr[n.x][n.y] = 0;
					}
					arr[nx][ny]=-1;
				}
				
			}
			else {
				System.out.println(time);
				break;
			}
		}
	}
	static class Node{
		int x;
		int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
