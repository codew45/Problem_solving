import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String star = "*";
        String space = " ";

        for(int i=N;i>0;i--){
            sb.append(space.repeat(N-i)).append(star.repeat(2*i-1)).append('\n');
        }
        for(int i=2;i<=N;i++){
            sb.append(space.repeat(N-i)).append(star.repeat(2*i-1)).append('\n');
        }
        System.out.print(sb);
      }
}