import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
    	int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new boolean[N][M];
        
        for(int i=0;i<N;i++){
        	String str = br.readLine();
            for(int j=0;j<M;j++){
            	if(str.charAt(j)=='B') arr[i][j] = true;
            	else arr[i][j] = false;
            }
        }
        int min = M*N+1;
        int cnt=0;
        
        for(int i=0;i<N-7;i++) {
        	for(int j=0;j<M-7;j++) {
        		cnt = check(i,j);
                min = Math.min(cnt, min);
        	}
        }
        System.out.print(min);
    }
    public static int check(int x, int y) {
        int B=0;
        int W = 0;
        
    	for(int i=x;i<x+8;i++) {
    		for(int j=y;j<y+8;j++) {
    			if((i+j)%2==0){
                    if(arr[i][j]) W++;
                    else B++;
                }
                else{
                    if(arr[i][j]) B++;
                    else W++;
                }
    		}
    	}
    	return Math.min(B,W);
    }
}