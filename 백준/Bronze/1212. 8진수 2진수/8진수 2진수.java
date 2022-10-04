import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<str.length();i++) {
			String tmp = Integer.toBinaryString(str.charAt(i)-'0');
			
			if(tmp.length()==2&&i!=0) sb.append('0');
			else if(tmp.length()==1&&i!=0) sb.append("00");
			sb.append(tmp);
		}
		System.out.println(sb);
	}

}
