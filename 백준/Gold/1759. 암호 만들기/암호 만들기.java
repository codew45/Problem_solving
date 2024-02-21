import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/***
 * 암호문 길이 L
 * 문자 종류 C개
 * 
 * 앞글자보다 클 때만 조합을 ㄱㄱ한다 
 * 모음이 최소 한개 자음이 최소 2개 
 *
 */
public class Main {
	
	static char[] input;
	static boolean[] isSelected;
	static char[] password;
	static int L;	
	static int C;	
	static ArrayList<Character> vowels = new ArrayList<>();
	
	static StringBuilder sb = new StringBuilder();
	static void comb(int cnt, int start) {
		if(cnt==L) {
			int vowelCnt = 0;
			for(int i=0;i<password.length;i++) {
				if(vowels.contains(password[i])) vowelCnt++;
			}
			if(vowelCnt>0&&vowelCnt<=L-2) {
				for(char c:password) sb.append(c);
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			password[cnt] = input[i];
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		input = new char[C];
		isSelected = new boolean[C];
		
		password = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) input[i] = st.nextToken().charAt(0);
		Arrays.sort(input);
		comb(0,0);
		System.out.println(sb);
	}

}
