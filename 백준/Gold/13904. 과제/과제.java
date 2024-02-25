import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Homework[] homeworks = new Homework[n];
		
		int lastDay = -1;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			// 과제의 마지막 마감일
			lastDay = Math.max(lastDay,day);
			// 숙제 배열에 데이터 저장
			homeworks[i] = new Homework(day, score);
		}
		
		// 숙제들을 마감일의 내림차순으로 정렬
		Arrays.sort(homeworks, (o1,o2)-> o2.day-o1.day);
		
		int answer = 0;
		int hwIdx = 0;
		
		PriorityQueue<Homework> pq = new PriorityQueue<>();
		for(int i=lastDay;i>0;i--) {
			while(hwIdx<n && homeworks[hwIdx].day==i) {
				pq.offer(homeworks[hwIdx++]);
			}
			if(!pq.isEmpty())answer += pq.poll().score;
		}
		System.out.println(answer);
		
		
	}
	static class Homework implements Comparable<Homework>{
		int day;
		int score;
		public Homework(int day, int score) {
			this.day = day;
			this.score = score;
		}

		@Override
		public int compareTo(Homework o) {
			return o.score-this.score;
		}

	}
}
