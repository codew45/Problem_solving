import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt = 0;
	static int N;
	static int M;
	static char[][] campus;
	static boolean[][] visited;
	
	static void bfs(Point start) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		visited[start.x][start.y]= true; 
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]) {
					if(campus[nx][ny]!='X') {
						q.add(new Point(nx,ny));
						visited[nx][ny] = true;
						if(campus[nx][ny]=='P') cnt++;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		campus = new char[N][M];
		visited = new boolean[N][M];
		int startX = 0;
		int startY = 0;
		
		for(int i=0;i<N;i++) {
			campus[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(campus[i][j]=='I') {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(new Point(startX,startY));
//		System.out.println((cnt>0)?cnt:"TT");
		if(cnt==0) System.out.println("TT");
		else System.out.println(cnt);
		
	}

}
