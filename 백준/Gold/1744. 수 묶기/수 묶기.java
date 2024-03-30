import java.io.*;
import java.util.*;

/*
 * 양수랑 음수를 따로 저장.
 * 
 * 양수는 내림차순으로 정렬.
 * 앞에서부터 2개씩 묶음
 * 
 * 음수는 오름차순으로 정렬.
 * 앞에서 2개씩 묶음
 * 
 * 양수 0 -> 더해
 * 음수 0 -> 곱해
 * 
 * 둘 중 하나가 1인데 하나가 1보다 커
 * 그럼 
 * 0이 있어 근데
 * 음수배열의 길이가 홀수 -> 그럼 마지막거랑 *0해버려
 * 
 */
	
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		
		int zeroCnt = 0;
		
		for(int i=0;i<n;i++) {
			int data = Integer.parseInt(br.readLine());
			if(data==0) {
				zeroCnt++;
			}
			else if(data>0) {
				positive.add(data);
			}
			else if(data<0) {
				negative.add(data);
			}
		}
		
		int pLen = positive.size();
		int nLen = negative.size();
		
		Collections.sort(positive, (o1,o2)->{
			return o2-o1;
		});
		
		Collections.sort(negative, (o1,o2)->{
			return o1-o2;
		});
		
//		System.out.println(Arrays.toString(positive.toArray()));
//		System.out.println(Arrays.toString(negative.toArray()));
		
		int result = 0;
		
		for(int i=0;i<=pLen-2;i+=2) {
			int a = positive.get(i);
			int b = positive.get(i+1);
			
			if(b==1) {
				result += a+b;
			}
			else {
				result += a*b;
			}
		}
		// 홀수면 마지막거는 그냥 더한다
		if(pLen%2!=0) {
			result += positive.get(pLen-1);
		}
		
		
		for(int i=0;i<=nLen-2;i+=2) {
			result += negative.get(i)*negative.get(i+1);
		}

		if(nLen%2!=0 && zeroCnt==0) {
			result += negative.get(nLen-1);
		}
		
		System.out.println(result);
	}

}
