import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String str = "*";
        String space = " ";

        sb.append(space.repeat(N-1)).append(str).append('\n');
        for(int i=1;i<N-1;i++){
            sb.append(space.repeat(N-i-1)).append(str).append(space.repeat(i*2-1)).append(str);
            sb.append('\n');
        }
        if(N!=1) sb.append(str.repeat(N*2-1));
        System.out.print(sb);
      }
}