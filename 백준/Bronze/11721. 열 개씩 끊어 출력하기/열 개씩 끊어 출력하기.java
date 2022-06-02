import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int l = str.length();
        for(int i=0;i<l/10;i++){
            System.out.println(str.substring(i*10,(i+1)*10));
        }
        if(l%10!=0){
            System.out.println(str.substring(l-(l%10)));
        }
        
    }
}