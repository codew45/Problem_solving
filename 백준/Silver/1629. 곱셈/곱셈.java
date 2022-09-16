import java.io.*;
import java.util.*;
public class Main{
    static int C;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        System.out.println(pow(A, B));
    }
    
    static long pow(int a, int b){
        
        if(b==1){
            return a % C;
        }
        
        long tmp = pow(a, b/2);
        
        if(b%2==1){
            return (tmp*tmp%C)*a%C;
        }
        
        return tmp*tmp%C;
    }
    
}