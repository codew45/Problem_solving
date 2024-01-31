import java.io.*;
public class Main{
	static int min = Integer.MAX_VALUE;
    static int xValue;
	static int [] data;
	static int [] numbers;
	static boolean [] visited;
	
	public static void perm(int cnt) {
		if(cnt==data.length) {
			String num = "";
			for(int n : numbers) {
				num += n;
			}
			int tmp = Integer.parseInt(num);
			if(tmp>xValue) min = Math.min(min, tmp);
		}
		for(int i=0;i<data.length;i++) {
			if(!visited[i]) {
				numbers[cnt] = data[i];
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		int len = x.length();
		
		data = new int[len];
		numbers = new int[len];
		visited = new boolean[len];
		
        xValue = Integer.parseInt(x);
		
		for(int i=0;i<len;i++) {
			data[i] = x.charAt(i)-'0';
		}
		perm(0);
		min = (min==Integer.MAX_VALUE)?0:min;
		System.out.println(min);
	}

}
