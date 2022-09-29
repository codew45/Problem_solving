import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> s = new Stack<Character>();
		
		int res = 0;
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(c=='(') {
				s.push(c);
			}
			
			else if(c==')'){
				s.pop();
				if(str.charAt(i-1)=='(') {
					res += s.size();
				}
				else {
					res += 1;
				}
				
			}
		}
		System.out.println(res);
	}

}
