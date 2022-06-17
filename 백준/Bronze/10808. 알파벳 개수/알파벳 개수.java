import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] cnt = new int[26];
		
		for(int i=0;i<str.length();i++) {
			cnt[str.charAt(i)-'a']++;
		}
		
		for(int val : cnt) {
			System.out.print(val+" ");
		}
	}
}
