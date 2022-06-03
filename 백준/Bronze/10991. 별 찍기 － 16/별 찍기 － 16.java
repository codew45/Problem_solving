import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String str = "* ";
        String space = " ";

        for(int i=0;i<N;i++){
            sb.append(space.repeat(N-i-1)).append(str.repeat(i+1)).append('\n');
        }
        System.out.print(sb);
      }
}