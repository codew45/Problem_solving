import java.io.*;
import java.util.*;

public class Main{
    
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int maxStep = Integer.MIN_VALUE;
    
    static int dfs(int x, int y){
        
        if(dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = 1;
        
        for(int d=0; d<4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if(nx >= 0 && nx<N && ny>=0 && ny<N && map[x][y] < map[nx][ny]){
                
                if(dp[nx][ny]==0){
                    dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
                }else{
                    dp[x][y] = Math.max(dp[x][y], dp[nx][ny]+1);
                }
            }
        }
        
        return dp[x][y];
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                maxStep = Math.max(maxStep,dfs(i, j));
            }
        }
        
        System.out.println(maxStep);
    }
}