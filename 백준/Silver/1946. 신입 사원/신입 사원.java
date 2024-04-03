import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Score> pq;
	
	static int count() {
		int result = 1;
		Score cur = pq.poll();
		int curInterview = cur.interview;
		while(!pq.isEmpty()) {
			Score next = pq.poll();
			if(curInterview>next.interview) {
				result++;
				curInterview = next.interview;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			pq = new PriorityQueue<Score>((o1,o2)->
			o1.document-o2.document);
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				pq.add(new Score(document, interview));
				
			}
			sb.append(count()+"\n");
		}
		System.out.println(sb);
	}
	
	static class Score{
		int document;
		int interview;
		public Score(int document, int interview) {
			super();
			this.document = document;
			this.interview = interview;
		}
	}
}
