import java.io.*;
import java.util.*;
/*
 * 연종이가 하루동안 본 걸 모두 수첩1에 저장
 * M개의 질문을 해서, 봤다고 주장하는 걸 수첩 2에다가 저장
 * 
 * 수첩 2에 적힌 순서대로 수첩 1에 있으면 1 없으면 0 
 * 
 * 이진탐색하면 댄다아이가
 * 
 * 
 */
public class Main {
	static ArrayList<Integer> input;

	static int binarySearch(int target) {
		int start = 0;
		int end = input.size()-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(input.get(mid)==target) {
				return mid;
			}
			else if(input.get(mid)>target) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			input = new ArrayList<>();
			for(int i=0;i<n;i++) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(input);
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<m;i++) {
				int target = Integer.parseInt(st.nextToken());
				if(binarySearch(target)!=-1) {
					sb.append(1+"\n");
				}
				else {
					sb.append(0+"\n");
				}
				
			}
			
		}
		System.out.println(sb);

	}

}
