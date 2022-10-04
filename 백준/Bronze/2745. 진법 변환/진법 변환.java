import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		StringBuffer rev = new StringBuffer(N);
		rev = rev.reverse();
		
		int result = 0;
		
		for(int i=0;i<rev.length();i++) {
			char c = rev.charAt(i);
			if(c>='0'&&c<='9') {
				double tmp = ((int)(c-'0'))*Math.pow(B, i);
				
				result += tmp;
			}
			else {
				double tmp = ((int)(c-'A'+10))*Math.pow(B, i);
				
				result += tmp;
				}
		}
		System.out.println(result);
	}

}
