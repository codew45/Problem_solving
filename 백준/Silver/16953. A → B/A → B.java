import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
 * 2를 곱한다
 * 1을 맨오른쪽에 추가한다
 * 
 * 
 * 불가능한 경우
 * -> 현재 수가 B보다 커졌을 때
 * 
 */
public class Main {
	static int a;
	static int b;
	static TreeSet<Long> set = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		set.add((long) a);
		
		int answer = 0;
		
		Loop1:
		while(true) {
			TreeSet<Long> tmp = new TreeSet<>();
			answer++;
			for(long data:set) {
				if(data==b) {
					System.out.println(answer);
					break Loop1;
				}
				
				long first = data*2;
				long second = data*10+1;
				if(first<=b) {
					tmp.add(first);
				}
				if(second<=b) {
					tmp.add(second);
				}
			}
			set = tmp;
			if(set.size()==0) {
				System.out.println(-1);
				break;
			}
			
		}
		
	}

}
