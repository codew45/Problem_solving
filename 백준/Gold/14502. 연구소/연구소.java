import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int M;
	static int[][] lab;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int maxSafetyArea = Integer.MIN_VALUE;
	static Queue<Point> virusPosition = new ArrayDeque<>();
	
	static void permutation(int wallCnt) {
		if(wallCnt==3) {
			bfs(lab);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(lab[i][j]==0) {
					lab[i][j] = 1;
					permutation(wallCnt+1);
					lab[i][j] = 0;
				}
			}
		}
	}
	
	private static void bfs(int[][] lab) {
		Queue<Point> q = new ArrayDeque<>(virusPosition);
		int[][] tmp = new int[N][M];
		for(int i=0;i<N;i++) tmp[i] = lab[i].clone();
		
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&tmp[nx][ny]==0) {
					tmp[nx][ny] = 2;
					q.add(new Point(nx,ny));
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++){
				if(tmp[i][j]==0) cnt++;
			}
		}
		
		maxSafetyArea = Math.max(cnt, maxSafetyArea);
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j]==2) virusPosition.add(new Point(i,j));
			}
		}

		permutation(0);
		System.out.println(maxSafetyArea);

	}
	

}
