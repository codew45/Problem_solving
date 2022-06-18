import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		
		for(int i=0;i<arr[0].length();i++) {
		boolean diff=false;
			for(int j=0;j<N-1;j++) {
				if(arr[j].charAt(i)!=arr[j+1].charAt(i)) {
					diff = true;
					break;
				}
			}
			
			if(diff)
				System.out.print('?');
			else
				System.out.print(arr[0].charAt(i));
		
		}
		
	}

}
