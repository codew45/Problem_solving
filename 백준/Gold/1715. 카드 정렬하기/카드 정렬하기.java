import java.io.*;
import java.util.PriorityQueue;
/*
 * 10 20 40
 *  10 20 -> 30 -> 40
 * 
 *  a장+b장 비교해서 a+b장
 *  a+b장이랑 c장이랑 비교
 *  -> a+b+a+b+c가 되니까 a+b가 최소가 되게 하려면 정렬하고,  
 * 
 * 
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long answer = 0;
		
		for(int i=0;i<n;i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		// 두 개씩 뽑아서 더한 다음에 다시 pq에 넣음
		
		while(pq.size()>1) {
			long a = pq.poll();
			long b = pq.poll();
//			System.out.println("A "+a);
//			System.out.println("B "+b);
			pq.add(a+b);
			answer += a+b;
//			System.out.println(a+b);
//			System.out.println(pq.size());
		}
//		System.out.println(pq.peek());
		System.out.println(answer);
		
	}

}
