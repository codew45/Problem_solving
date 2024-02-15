import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static int H;
	static int W;
	static int posX;
	static int posY;
	static int dir;
	
	public static void move(char cmd) {
		switch(cmd) {
		case 'U':
			dir = 0;
			map[posX][posY] = '^';
			break;
		case 'D':
			dir = 1; 
			map[posX][posY] = 'v';
			break;
		case 'L':
			dir = 2;
			map[posX][posY] = '<';
			break;
		case 'R':
			dir = 3;
			map[posX][posY] = '>';
			break;
		}
		int nx = posX+dx[dir];
		int ny = posY+dy[dir];
		
		if(rangeCheck(nx,ny)&&map[nx][ny]=='.') {
			map[nx][ny] = map[posX][posY];
			map[posX][posY] = '.';
			posX = nx;
			posY = ny;
		}
		return;
	}
	public static boolean rangeCheck(int nx,int ny) {
		return nx>=0&&nx<H&&ny>=0&&ny<W;
	}
	
	public static void shooting() {
		int nx = posX;
		int ny = posY;
		while(true) {
			nx += dx[dir];
			ny += dy[dir];
			if(rangeCheck(nx,ny)) {
				if(map[nx][ny]=='*') {
					map[nx][ny] = '.';
					return;
				}
				else if(map[nx][ny]=='#') return;
			}else return;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>') {
						dir = 0;
						posX = i;
						posY = j;
					}
					if(map[i][j]=='v') {
						dir = 1;
					}
					if(map[i][j]=='<') {
						dir = 2;
					}
					if(map[i][j]=='>') {
						dir = 3;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] commands = br.readLine().toCharArray();
			
			for(int i=0;i<N;i++) {
				char cmd = commands[i];
				if(cmd=='S') {
					shooting();
				}
				else {
					move(cmd);
				}
			}
			
			sb.append("#"+t+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
