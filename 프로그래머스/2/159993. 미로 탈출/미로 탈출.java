import java.io.*;
import java.util.*;
import java.awt.*;

class Solution {
    static int[] dx = {-1 ,1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static int N, M;
    static Point start;
    static Point dest;
    static Point lever;
    static char[][] charMap;
    static int[][] visited;
    
    static int bfs(Point startPoint, Point endPoint){
        Deque<Point> q = new ArrayDeque<>();
        visited[startPoint.x][startPoint.y] = 1;
        q.add(startPoint);
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            if(x == endPoint.x && y == endPoint.y){
                return visited[x][y];
            }
            
            for(int d=0;d<4;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                
                if(nx>=0 && nx < N && ny >= 0 && ny< M && visited[nx][ny] == 0 && charMap[nx][ny] != 'X') {
                    // System.out.println("NX NY   " +nx+"    "+ny+"  TIME   "+time);
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        
        return 0;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
            
        charMap = new char[N][M];
        visited = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M;j++){
                charMap[i][j] = maps[i].charAt(j);
                if(charMap[i][j] == 'S'){
                    start = new Point(i,j);
                }else if(charMap[i][j] == 'E'){
                    dest = new Point(i,j);
                }else if(charMap[i][j] == 'L'){
                    lever = new Point(i,j);
                }
            }
        }
        
        int timeToLever = bfs(start, lever);
        visited = new int[N][M];
        int timeToDest = bfs(lever, dest);
        
        // System.out.println(timeToLever+"   "+timeToDest);
        
        if(timeToLever == 0 || timeToDest == 0){
            answer = -1;
        }else{
            answer = timeToLever-1 + timeToDest-1;
        }
        
        return answer;
    }
}