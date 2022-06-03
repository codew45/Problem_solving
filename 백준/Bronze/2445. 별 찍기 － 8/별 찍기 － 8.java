import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String star = "*";
        String space = " ";
        
        for(int i=1;i<=N;i++){
            sb.append(star.repeat(i)).append(space.repeat((N-i)*2)).append(star.repeat(i));
            sb.append('\n');
        }
        for(int i=N-1;i>0;i--){
            sb.append(star.repeat(i)).append(space.repeat((N-i)*2)).append(star.repeat(i));
            sb.append('\n');
        }                                 
        System.out.print(sb);
      }
}