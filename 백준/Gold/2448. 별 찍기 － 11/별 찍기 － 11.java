import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] str = new String[n];
        str[0] = "  *  ";
        str[1] = " * * ";
        str[2] = "*****";
        
        for(int k=1;3*(int)Math.pow(2,k)<=n;k++){
            star(k, str);
        }
        
        for(int i=0;i<n;i++){
            System.out.println(str[i]);
        }
    }
    public static void star(int k, String[] str){
        int bottom = 3*(int)Math.pow(2,k);
        int middle = bottom/2;
        
        for(int i=middle;i<bottom;i++){
            str[i] = str[i-middle]+" "+str[i-middle];
        }
        String space = "";
        while(space.length()<middle){
            space +=" ";
        }
        for(int i=0;i<middle;i++){
            str[i] = space+str[i]+space;
        }
    }
}