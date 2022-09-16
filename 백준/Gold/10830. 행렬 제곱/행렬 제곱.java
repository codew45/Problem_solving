import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] result = pow(arr, B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
	static int[][] pow(int[][] src, long b){
		
		if(b==1) {
			return src;
		}
        
		int[][] tmp = new int[N][N];
        
		tmp = pow(src, b/2);
		
		tmp = multiply(tmp, tmp);
		
		if(b%2==1) {
			tmp = multiply(tmp, arr);
		}
		
		return tmp;
	}
	
	static int[][] multiply(int[][] A, int[][] B){
		
		int[][] tmp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					tmp[i][j] += A[i][k]*B[k][j];
					tmp[i][j] %= 1000;
				}
			}
		}
		return tmp;
	}
	

}