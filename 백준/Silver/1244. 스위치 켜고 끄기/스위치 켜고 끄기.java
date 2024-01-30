import java.io.*;
import java.util.*;

public class Main {
	static int[] switches;
	public static void flip(int idx) {
		switches[idx] = 1-switches[idx];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		switches = new int[N+1];
		for(int i=1;i<=N;i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0;i<cnt;i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				for(int j=num;j<=N;j+=num) flip(j);
			}
			else if(gender==2) {
				flip(num);
				for(int j=1;j<=N/2;j++) {
					if(num+j<=N && num-j>0) {
						if(switches[num+j]==switches[num-j]) {
							flip(num+j);
							flip(num-j);
						}
						else break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			sb.append(switches[i]).append(" ");
			if(i%20==0) sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
