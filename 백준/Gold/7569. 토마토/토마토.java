import java.io.*;
import java.util.*;
public class Main {
   
	static int N;
	static int M;
	static int H;
	static int[][][] tomatoes;
	static Queue<Tomato> q = new ArrayDeque<>();

	static int[] dz = {-1,1,0,0,0,0};
	static int[] dx = {0,0,0,0,1,-1};
	static int[] dy = {0,0,-1,1,0,0};
	static int answer = 0;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			int z = cur.z; 
			int x = cur.x;
			int y = cur.y;
			
			for(int i=0;i<6;i++) {
				int nz = z+dz[i];
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(rangeCheck(nz,nx,ny)&&tomatoes[nz][nx][ny]==0) {
					q.add(new Tomato(nz, nx, ny));
					tomatoes[nz][nx][ny] = tomatoes[z][x][y]+1;
				}
			}
		}
		
	}
	public static boolean rangeCheck(int z, int x, int y) {
		return z>=0&&z<H&&x>=0&&x<N&&y>=0&&y<M;
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    H = Integer.parseInt(st.nextToken());
	    
	    tomatoes = new int[H][N][M];
	    
	    for(int z=0;z<H;z++) {
	        for(int x=0;x<N;x++) {
	            st = new StringTokenizer(br.readLine());
	            for(int y=0;y<M;y++) {
	            	tomatoes[z][x][y] = Integer.parseInt(st.nextToken());
	            	if(tomatoes[z][x][y]==1) {
	    				q.add(new Tomato(z,x,y));
//	    				if(!visited[z][x][y]) bfs(new Tomato(z,x,y));
	    			}
	                
//	                System.out.print(tomatoes[z][x][y]+" ");
	            }
//	            System.out.println();
	        }
	    }
	    
	    bfs();
	    
	    
	    int max = -2;
	    boolean impossible = false;
	    
	    loop1:
	    for(int z=0;z<H;z++) {
	    	for(int x=0;x<N;x++) {
	    		for(int y=0;y<M;y++) {
	    			if(tomatoes[z][x][y]==0) {
	    				impossible = true;
	    				break loop1;
	    			}
	    			
	    			max = Math.max(max, tomatoes[z][x][y]);
//	    			System.out.print(tomatoes[z][x][y]+" ");
	    		}
//	    		System.out.println();
	    	}
	    }
	    
	    if(!impossible) {
	    	if(max==1) System.out.println(0);
	    	else System.out.println(max-1);
	    }
	    else {
	    	System.out.println(-1);
	    }
	    
	}
	
	static class Tomato{
		int z;
		int x;
		int y;
		public Tomato(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
		
	}
}