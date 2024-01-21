import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[3];
			
			for(int i=0;i<3;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			if(nums[0]==0 & nums[1]==0 & nums[2]==0) {
				break;
			}
			
			Arrays.sort(nums);
			
			if((Math.pow(nums[0], 2)+Math.pow(nums[1], 2))==Math.pow(nums[2], 2)) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
	}

}
