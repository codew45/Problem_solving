import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [][] arr = new char[5][];
		
		int max_len = Integer.MIN_VALUE;
		
		for(int i=0;i<5;i++) {
			arr[i] = (br.readLine()).toCharArray();
			
			if(max_len<arr[i].length) {
				max_len = arr[i].length;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int j=0;j<max_len;j++) {
			for(int i=0;i<5;i++) {
				if(arr[i].length>j) {
					sb.append(arr[i][j]);
				}
			}
		}
		System.out.println(sb);
	}

}
