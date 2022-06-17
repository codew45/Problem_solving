import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = (br.readLine()).split("-");
		
		int res = 0;
		
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			String[] addition = arr[i].split("\\+");
			
			for(int j=0;j<addition.length;j++) {
				sum += Integer.parseInt(addition[j]);
			}
			
			if(i==0) {
				res += sum;
			}
			else {
				res -= sum;
			}
		}
		System.out.println(res);
	}
}
