import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int d = gcd(A,B);
            System.out.println(A*B/d);
        }
    }
    
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a % b;
            
            a = b;
            b = r;
        }
        return a;
    }
}