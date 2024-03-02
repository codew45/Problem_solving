import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	static Fish shark;
	static int time = 0;
	static int size = 2;
	static int fishCnt = 0;
	static PriorityQueue<Fish> fishes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark = new Fish(i,j, 0);
				}
			}
		}
		
		while(true) {
			findFish();
			if(fishes.isEmpty()) {
				System.out.println(time);
				break;
			}
			eatFish();
		}
	}
	
	
	static void findFish() {
		fishes = new PriorityQueue<>();
		visited = new boolean[N][N];
		Queue<Fish> q = new ArrayDeque<>();
		q.offer(shark);
		visited[shark.x][shark.y] = true;
		
		while(!q.isEmpty()) {
			Fish cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int dist = cur.dist;
			if(map[x][y]>0&&map[x][y]<size&&!visited[x][y]) {
				fishes.add(new Fish(x,y,dist));
			}
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
					if(map[nx][ny]<=size) {
						q.offer(new Fish(nx,ny, dist+1));
						visited[nx][ny] = true;
						if(map[nx][ny]>0 && map[nx][ny]<size) {
							fishes.offer(new Fish(nx,ny,dist+1));
						}
					}
				}
			}
		}
		
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void eatFish() {
		Fish nowFish = fishes.poll();
		time += nowFish.dist;
		fishCnt++;
		if(fishCnt==size) {
			size+=1;
			fishCnt = 0;
		}
		map[shark.x][shark.y] = 0; 
		shark.x = nowFish.x;
		shark.y = nowFish.y;
		visited[nowFish.x][nowFish.y] = true;
		map[shark.x][shark.y] = 9; 
		
		
	}

	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int dist;
		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.dist<o.dist) return -1;
			else if(this.dist>o.dist) return 1;
			else {
				// 탐색시간이 같으면
				if(this.x<o.x) return -1;
				else if(this.x>o.x) return 1;
				else {
					if(this.y<o.y) return -1;
					else if(this.y>o.y) return 1;
				}
			}
			return 0;
		}
		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
		
	}

}
