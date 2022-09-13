import java.io.*;
import java.util.*;
public class Main{
    static int arr[][];
    static int[] cnt = new int[2];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0,0,n);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }
    static void partition(int x, int y, int size){
        if(colorCheck(x,y,size)==0){
            cnt[0]++;
        }else if(colorCheck(x,y,size)==1){
            cnt[1]++;
        }
        else{
            int newsize = size/2;
            partition(x,y,newsize);
            partition(x,y+newsize,newsize);
            partition(x+newsize,y,newsize);
            partition(x+newsize,y+newsize,newsize);
        }
    }
    static int colorCheck(int x, int y, int size){
        int color = arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(color!=arr[i][j]) return -1;
            }
        }
        if(color ==0) return 0;
        else return 1;
    }
}