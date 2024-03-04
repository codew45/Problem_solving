import java.io.*;
import java.util.*;

public class Main {
	static int n = 5;
	static int[][] board = new int[n][n];
	static int bingoCnt = 0;
	
	static void rowCheck() {
		for(int i=0;i<n;i++) {
			int tmp = 0;
			for(int j=0;j<n;j++) {
				tmp += board[i][j];
			}
			if(tmp==0) bingoCnt++;
		}
	}
	static void colCheck() {
		for(int i=0;i<n;i++) {
			int tmp = 0;
			for(int j=0;j<n;j++) {
				tmp += board[j][i];
			}
			if(tmp==0) bingoCnt++;
		}
	}
	static void leftDiagCheck() {
		int tmp = 0;
		for(int i=0;i<n;i++) {
			tmp += board[i][i];
		}
		if(tmp==0) bingoCnt++;
	}
	static void rightDiagCheck() {
		int tmp = 0;
		for(int i=0;i<n;i++) {
			tmp += board[i][n-i-1];
		}
		if(tmp==0) bingoCnt++;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=n*n;i++) {
			int a = sc.nextInt();
			for(int k=0;k<n;k++) {
				for(int l=0;l<n;l++) {
					if(board[k][l]==a) {
						board[k][l] = 0;
						
					}
				}
			}
			
			if(i>11) {
				rowCheck();
				colCheck();
				leftDiagCheck();
				rightDiagCheck();
				
				if(bingoCnt>=3) {
					System.out.println(i);
					break;
				}
				bingoCnt=0;
			}
			
			
		}
		
		
		
	}

}
