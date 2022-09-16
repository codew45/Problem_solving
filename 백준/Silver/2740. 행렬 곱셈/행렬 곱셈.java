import java.io.*;
import java.util.*;

public class Main{
    static int[][] A;
    static int[][] B;
    static int[][] C;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        A = new int[N][M];
        for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j=0;j<M;j++){
	         A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        B = new int[M][K];
        C = new int[N][K];
        
        for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j=0;j<K;j++){
	         B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<K;j++){
                
                for(int k=0;k<M;k++){
                    C[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<K;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}