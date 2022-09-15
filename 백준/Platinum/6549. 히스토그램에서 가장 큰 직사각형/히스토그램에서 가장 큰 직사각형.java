import java.io.*;
import java.util.*;
public class Main {
	static long[] histogram;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = new String();
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0) {
				break;
			}
			
            histogram = new long[n];
            
			for(int i=0;i<n;i++) {
				histogram[i] = Long.parseLong(st.nextToken());
			}
			
			sb.append(getArea(0, n-1)).append('\n');
			histogram = null;
		}
		
		System.out.println(sb);
	
		
	}
	
	public static long getArea(int low, int high) {
		
		if(low==high) {
			return histogram[low];
		}
		
		int mid = (low+high)/2;
		
		long leftArea = getArea(low, mid);
		long rightArea = getArea(mid+1, high);
		
		long max = Math.max(leftArea,  rightArea);
		
		max = Math.max(max, getMidArea(low, high, mid));
		
		return max;
	}
	
	public static long getMidArea(int low, int high, int mid) {
		
		int toLeft = mid;
		int toRight = mid;
		
		long height = histogram[mid];
		
		long maxArea = height;
		
		while(low < toLeft && high > toRight) {
			if(histogram[toLeft-1]<histogram[toRight+1]) {
				toRight++;
				height = Math.min(height,  histogram[toRight]);
			}
			else {
				toLeft--;
				height = Math.min(height, histogram[toLeft]);
			}
			
			maxArea = Math.max(maxArea, height*(toRight-toLeft+1));
		}
		
		
		while(high>toRight) {
			toRight++;
			height = Math.min(height,  histogram[toRight]);
			maxArea = Math.max(maxArea, height*(toRight-toLeft+1));		
		}
		while(low<toLeft) {
			toLeft--;
			height = Math.min(height,  histogram[toLeft]);
			maxArea = Math.max(maxArea, height*(toRight-toLeft+1));		
		}
		
		return maxArea;
	}

}
