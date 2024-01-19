import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum=0;
        for(int i=0;i<3;i++){
            sum += Double.parseDouble(st.nextToken());
        }
        System.out.println(Math.round(sum));
    }
}