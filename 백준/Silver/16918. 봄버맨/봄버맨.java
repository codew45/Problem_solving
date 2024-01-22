import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// R C N 입력
		// R x C 보드 생성
		// R 줄에 걸쳐 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char [][] board = new char[R][C];
		
		Queue<Pair>bombs = new LinkedList<Pair>();
		
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(board[i][j]=='O') {
					bombs.add(new Pair(i,j));
				}
			}
		}
		
		N-=1;
		// bombs 큐 생성
		// 방향벡터 생성
		
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		
		// N이 0이 될 때까지 반복
		// o인 부분의 x, y를 큐에 넣음
		// N -=1
		// 모든 칸을 o로
		// N-=1
		// bombs가 텅 빌 때까지
		// bomb의 x,y에서 4방향 돌면서 범위 안넘으면 .으로
		// 다 끝나면 -=1
		
		
		while(N>0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					board[i][j] = 'O';
				}
			}
			N-=1;
			
			if(N==0) break;
			while(!bombs.isEmpty()) {
				Pair p = bombs.poll();
				int x = p.x;
				int y = p.y;
				board[x][y] = '.';
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(0<=nx && nx<R && 0<=ny && ny<C) {
						board[nx][ny] = '.';
					}
				}
			}
			
			N-=1;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(board[i][j]=='O') {
						bombs.add(new Pair(i,j));
					}
				}
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