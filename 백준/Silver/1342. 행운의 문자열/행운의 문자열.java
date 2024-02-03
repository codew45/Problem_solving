import java.io.*;
public class Main {

	static char[] alphabet = new char[26];
	static int len;
	static int ans = 0;
	public static void dfs(int cnt, char prev) {
		if(cnt==len) {
			ans++;
			return;
		}
		for(int i=0;i<26;i++) {
			if(alphabet[i]==0) continue;
			if(prev!=(char)('a'+i)) {
				alphabet[i]--;
				dfs(cnt+1,(char)('a'+i));
				alphabet[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		len = s.length();
		for(int i=0;i<len;i++) {
			alphabet[s.charAt(i)-'a']++;
		}
		
		dfs(0,' ');
		System.out.println(ans);
	}

}
