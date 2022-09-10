import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)(Math.pow(2, N)-1));
        hanoi(N, 1, 3, 2);
        System.out.print(sb);
    }
    public static void move(int n, int from, int to){
        sb.append(from).append(" ").append(to).append('\n');
    }
    public static void hanoi(int n, int from, int to, int via){
        if(n==1){
            move(n, from, to);
            return;
        }
        else{
            hanoi(n-1, from, via, to);
            move(n, from, to);
            hanoi(n-1, via, to, from);
        }
    }
}