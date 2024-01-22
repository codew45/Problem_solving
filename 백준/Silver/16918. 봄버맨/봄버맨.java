import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;
public class Main {
	
	static int R;
	static int C;
	static int N;
	
	static char[][] board;	
	static boolean[][] visited;
	static Queue<Pair>bombs;
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void setBombs() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				board[i][j] = 'O';
			}
		}
	}
	
	public static void positionOfBombs() {
		bombs = new LinkedList<Pair>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]=='O') {
					bombs.add(new Pair(i,j));
				}
			}
		}
	}
	
	public static void explodeBombs() {
		visited = new boolean[R][C];
		
		
		while(!bombs.isEmpty()) {
			Pair p = bombs.poll();
			int x = p.x;
			int y = p.y;
			board[x][y] = '.';
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C && !visited[nx][ny]) {
					board[nx][ny] = '.';
					visited[nx][ny]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		positionOfBombs();
		
		if(N%2==0) {
			setBombs();
		}
		else {
			for(int i=0;i<N/2;i++) {
				setBombs();
				explodeBombs();
				positionOfBombs();
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}

}

class Pair{
	int x,y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}