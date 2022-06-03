import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String star = "*";
        String space = " ";
        
        for(int i=0;i<N;i++) {
            sb.append(space.repeat(i)).append(star.repeat(N-i)).append("\n");
        }
        System.out.print(sb);
    }
}