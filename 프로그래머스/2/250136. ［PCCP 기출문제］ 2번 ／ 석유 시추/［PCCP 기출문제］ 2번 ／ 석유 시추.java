import java.io.*;
import java.util.*;
import java.awt.*;

class Solution {
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] idx;
    static ArrayList<Integer> sizes = new ArrayList<>();
    
    static void bfs(Point start, int[][] land, int landIdx){
        if(idx[start.x][start.y] != -1) return;
        
        Deque<Point> q = new ArrayDeque<>();
        q.add(start);
        idx[start.x][start.y] = landIdx;
        int newSeokYou = 1;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<0 || nx >=N || ny<0 || ny>=M || idx[nx][ny] != -1 || land[nx][ny] == 0) continue;
                
                q.add(new Point(nx, ny));
                idx[nx][ny] = landIdx;
                newSeokYou++;
            }
        }
        sizes.add(newSeokYou);
        
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        idx = new int[N][M];
        int landIdx = 0;
        
        for(int i=0;i<N;i++){
            Arrays.fill(idx[i], -1);
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(idx[i][j]==-1 && land[i][j]==1){
                    bfs(new Point(i, j), land, landIdx);
                    landIdx++;
                }
            }
        }
        
        for(int j=0; j<M; j++){
            int sum = 0; 
            Set<Integer> idxSet = new HashSet<Integer>();
            for(int i=0; i<N; i++){
                if(idx[i][j] != -1){
                    if(!idxSet.contains(idx[i][j])){
                        sum += sizes.get(idx[i][j]);
                        idxSet.add(idx[i][j]);
                    }
                }
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
}