import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// dp배열의 인덱스 : 인원 수
		// dp[인덱스] : 인덱스명을 모으는 데에 필요한 최소비용
		int[] dp = new int[c+101];
		
		// 최소비용을 구해야 하니까 최댓값으로 초기화
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			// 비용, 인원수 입력 받음
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			// 입력받은 값으로 초기 최소비용을 업데이트 해줌
		
			
			for(int j=people;j<dp.length;j++) {
				int prevCost = dp[j-people];
				
				// prevCost가 Integer.MAX_VALUE인 경우
				// prevCost+cost 연산값이 요상해지기 조건 걸어줌
				if(prevCost!=Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j],prevCost+cost);
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		// c명 이상 데려올 수 있는 것들 중 최소비용인 것을 찾음
		for(int i=c;i<dp.length;i++) {
			answer = Math.min(dp[i], answer);
		}
		System.out.println(answer);
	}

}
