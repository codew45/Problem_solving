import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] Month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] Day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int total = 0;
        
        for(int i=0;i<m-1;i++){
            total += Month[i];
        }
        total += d;
        
        System.out.println(Day[total%7]);
        
    }
}