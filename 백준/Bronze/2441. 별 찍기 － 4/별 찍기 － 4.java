import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String star = "*";
        String space = " ";
        
        for(int i=0;i<N;i++) {
        	System.out.print(space.repeat(i));
        	System.out.print(star.repeat(N-i));
        	System.out.println("");
        }
    }
}