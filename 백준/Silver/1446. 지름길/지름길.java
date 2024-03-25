import java.io.*;
import java.util.*;

public class Main {
	static class ShortCut implements Comparable<ShortCut>{
		int from;
		int to;
		int dist;
		
		public ShortCut(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(ShortCut o) {
			return this.from-o.from;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[d+1];
		// 초기 거리값을 설정
		for(int i=0;i<dp.length;i++) {
			dp[i] = i;
		}
		
		// 지름길들을 담을 어레이리스트
		ArrayList<ShortCut> shortCuts = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			// 도착지점이 범위 안에 있을 때만 유효한 지름길임
			if(to<=d) {
				shortCuts.add(new ShortCut(from, to, dist));
			}
		}
		
		// 시작점 기준으로 지름길들을 정렬
		Collections.sort(shortCuts);
		
		for(int i=1;i<dp.length;i++) {
			dp[i] = Math.min(dp[i-1]+1, dp[i]);
			
			for(int j=0;j<shortCuts.size();j++) {
				
				ShortCut tmp = shortCuts.get(j);
				// 지름길이 있다면 지름길을 타지 않은 경우와 지름길을 타는 경우 중 짧은 것으로 갱신
				if(i==tmp.to) {
					dp[i] = Math.min(dp[i], dp[tmp.from]+tmp.dist);
				}
			}
		}
		System.out.println(dp[d]);
		
	}

}
