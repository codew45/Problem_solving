import java.io.*;
import java.util.*;

public class Main {
	
	static class Line{
		int start;
		int end;
		public Line(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Line [start=" + start + ", end=" + end + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Line> lines = new PriorityQueue<>(new Comparator<Line>() {
			@Override
			public int compare(Line o1,Line o2) {
				if(o1.end!=o2.end) {
					return o2.end-o1.end;
				}
				else {
					return o2.start-o1.start;
				}
			}
		});
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lines.offer(new Line(start, end));
		}
		
		Line line = lines.poll();
		int prevStart = line.start;
		int prevEnd = line.end;
		int len = line.end-line.start;
		
		while(!lines.isEmpty()) {
			Line next = lines.poll();
			int nextStart = next.start;
			int nextEnd = next.end;
//			System.out.println(next.toString());
			
			if(prevStart>nextEnd) {
				len += nextEnd - nextStart;
//				System.out.println(nextEnd - nextStart+" 추가");
			}
			else {
				if(prevStart>nextStart) {
					len += prevStart-nextStart;
//					System.out.println( prevStart-nextStart+" 추기");
				}
			}
			
			if(prevStart>nextStart) {
				prevStart = nextStart;
			}
			if(prevEnd<nextEnd) {
				prevEnd = nextEnd;
			}
//			System.out.println("LEN "+len);
		}
		System.out.println(len);

	}

}
