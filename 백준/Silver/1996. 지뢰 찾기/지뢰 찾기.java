import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[n][n];
		char[][] res = new char[n][n];
		
		int [] dx = {-1,-1,-1,0,0,1,1,1};
		int [] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!='.') {
					res[i][j] = '*';
				}
				else {
					char cnt = '0';
					for(int k=0;k<8;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && nx<n && ny>=0 && ny<n) {
							if(arr[nx][ny]!='.') {
								cnt += (arr[nx][ny]-'0');
								
							}
						}
						if(cnt>'9') cnt = 'M';
					}
					res[i][j] = cnt;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(res[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
