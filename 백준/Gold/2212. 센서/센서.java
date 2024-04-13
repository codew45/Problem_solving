import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		List<Integer> positions = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			positions.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(positions);
		List<Integer> diff = new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			diff.add(positions.get(i+1)-positions.get(i));
		}
		
		if(k>=n) {
			System.out.println(0);
		}else {
			int answer = 0;
			Collections.sort(diff, (o1,o2)->o2-o1);
			
			for(int i=k-1;i<diff.size();i++) {
				answer += diff.get(i);
			}
			System.out.println(answer);
		}
		
	}

}
