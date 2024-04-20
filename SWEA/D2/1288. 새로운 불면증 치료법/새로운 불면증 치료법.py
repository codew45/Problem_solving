import java.io.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int x = 0;
			int cnt = 1;
			
			while(true) {
				int newN = cnt*N;
				
				while(newN>0) {
					int tmp = newN%10;
					
					x |= (1<<tmp);
					newN /= 10;
				}
				
				if(x == (1<<10)-1) {
					sb.append("#"+t+" "+cnt*N+"\n");
					break;
				}else {
					cnt++;
				}
			}
		}
		System.out.println(sb);
	}

}
