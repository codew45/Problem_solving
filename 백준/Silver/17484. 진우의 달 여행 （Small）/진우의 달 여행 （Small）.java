import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
public class Main {
	static int n, m;
	static int[][] map;
	static int[][][] dp;
	static int[] dx = {1,1,1};
	static int[] dy = {-1,0,1};
	static int res = Integer.MAX_VALUE;
	
	static class Point{
		int x;
		int y;
		int dir;
		int fuel;
		Point(int x, int y, int dir, int fuel) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.fuel = fuel;
		}
	};
	
	static void bfs(Point start) {
		Deque<Point> q = new ArrayDeque<>();
		q.add(start);
		dp[start.x][start.y][start.dir] = map[start.x][start.y];
		
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int dir = cur.dir;
			int fuel = cur.fuel;
			
			if(x==n-1) {
				res = Math.min(res, fuel);
			}
			
			for(int nd=0;nd<3;nd++) {
				int nx = x+dx[nd];
				int ny = y+dy[nd];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || dir == nd) continue;
				
				if(dp[nx][ny][nd]>dp[x][y][dir]+map[nx][ny]) {
					dp[nx][ny][nd] = dp[x][y][dir]+map[nx][ny];
					q.add(new Point(nx,ny,nd,dp[nx][ny][nd]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m][3];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		
		for(int d=0;d<3;d++) {
			for(int j=0;j<m;j++) {
				bfs(new Point(0,j,d,map[0][j]));
			}	
		}
		
		System.out.println(res);
	}

}
