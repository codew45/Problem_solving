import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Main{
	public static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        star(0,0,N,false);
        
        for(int i=0;i<N;i++){
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void star(int x, int y, int n, boolean blank) {
    	
        if(blank){
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(n==1){
            arr[x][y] = '*';
            return;
        }
        
        int size = n/3;
        int cnt = 0;
        
        for(int i=x;i<x+n;i+=size){
            for(int j=y;j<y+n;j+=size){
                cnt++;
                if(cnt==5){
                    star(i, j, size, true);
                }
                else{
                    star(i, j, size, false);
                }
            }
        }
    }
}
 