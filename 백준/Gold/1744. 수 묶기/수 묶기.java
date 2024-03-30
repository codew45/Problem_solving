import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> positive = new ArrayList<>();
		ArrayList<Integer> negative = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a>0) positive.add(a);
			else negative.add(a);
		}
		
		positive.sort((o1,o2)->{
			return o2-o1;
		});
		
		negative.sort((o1, o2)->{
			return o1-o2;
		});
		
		int sum = 0;
		int pSize = positive.size();
		int nSize = negative.size();
		
		for(int i=0;i<pSize-1;i++) {
			if(i%2==0) {
				if(positive.get(i)==1||positive.get(i+1)==1) {
					sum += positive.get(i)+positive.get(i+1);
				}
				else {
					sum += positive.get(i)*positive.get(i+1);
				}
			}
		}
		if(pSize%2==1) sum += positive.get(pSize-1);
		
		for(int i=0;i<nSize-1;i++) {
			if(i%2==0) {
				sum += negative.get(i)*negative.get(i+1);
			}
		}
		
		if(nSize%2==1) {
			if(negative.get(nSize-1)!=0) {
				sum += negative.get(nSize-1);
			}
		}
		System.out.println(sum);
	}

}
