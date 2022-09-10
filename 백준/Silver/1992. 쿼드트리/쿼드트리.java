import java.io.*;
import java.util.*;
public class Main{
	static int board[][];
	static int[] cnt = new int[3];
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	
        	for(int j=0;j<n;j++) {
        		board[i][j] = str.charAt(j)-'0';
        	}
        }
        
        partition(0,0,n);
        System.out.println(sb);

        
    }
    
    public static void partition(int row, int col, int size) {
    	if(colorCheck(row, col, size)) {
    		sb.append(board[row][col]);
    		return;
    	}
    	
    	int newSize = size/2;
    	
    	sb.append('(');
    	
    	partition(row, col, newSize);
    	partition(row, col+newSize, newSize);
    	partition(row+newSize, col, newSize);
    	partition(row+newSize, col+newSize, newSize);
    	
    	sb.append(')');
    }
    
    public static boolean colorCheck(int row, int col, int size) {
    	int val = board[row][col];
    	
    	for(int i=row;i<row+size;i++) {
    		for(int j=col;j<col+size;j++) {
    			if(val!=board[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
