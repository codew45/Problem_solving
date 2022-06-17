import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0")) {
				break;
			}
			
			StringBuffer sb = new StringBuffer(str);
			
			if(str.equals(sb.reverse().toString())) {
				System.out.println("yes");
			}
			else System.out.println("no");
			
		}
	}
}
