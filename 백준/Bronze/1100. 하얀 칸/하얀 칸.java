import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[8];
        
        for(int i=0;i<8;i++){
            str[i] = br.readLine();
        }
        int cnt = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i%2==0&&j%2==0&&str[i].charAt(j)=='F')
                    cnt++;
                else if(i%2!=0&&j%2!=0&&str[i].charAt(j)=='F')
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}