import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int n = 9;
	static int[][] board = new int[n][n];
	static ArrayList<Point> zeros = new ArrayList<>();
	
	static void sudoku(int cnt) {
		if(cnt==zeros.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		boolean[] check = new boolean[n+1];
		
		Point cur = zeros.get(cnt);
		int x = cur.x;
		int y = cur.y;
		
		for(int i=0;i<n;i++) {
			if(board[x][i]!=0) {
				check[board[x][i]] = true;
			}
		}
		for(int i=0;i<n;i++) {
			if(board[i][y]!=0) {
				check[board[i][y]] = true;
			}
		}
		
		int startX = (x/3)*3;
		int startY = (y/3)*3;
		
		
		for(int i=startX; i<startX+3 ;i++) {
			for(int j=startY; j<startY+3; j++) {
				if(board[i][j]!=0) {
					check[board[i][j]] = true;
				}
			}
		}

		
		for(int i=1;i<=9;i++) {
			if(!check[i]) {
				board[x][y] = i;
				sudoku(cnt+1);
				board[x][y] = 0;
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<n;j++) {
				board[i][j] = input.charAt(j)-'0';
				if(board[i][j]==0) {
					zeros.add(new Point(i,j));
				}
			}
		}
		
		sudoku(0);
		
	}

}
