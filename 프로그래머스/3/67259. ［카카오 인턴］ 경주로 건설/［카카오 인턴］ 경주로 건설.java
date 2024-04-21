import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int N = board.length;
        int[][][] cost = new int[N][N][4];
        
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0,0,0,1});
        q.add(new int[]{0,0,0,3});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                
                int newCost = cur[2] + (cur[3] == d ? 100 : 600);
                if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny] != 1){
                    if(cost[nx][ny][d]==0){
                        cost[nx][ny][d] = newCost;
                        q.add(new int[]{nx,ny, newCost, d});
                    }else{
                        if(cost[nx][ny][d] >= newCost){
                            cost[nx][ny][d] = newCost;
                            q.add(new int[]{nx,ny, newCost, d});
                        }
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int d=0;d<4;d++){
            if(cost[N-1][N-1][d]!= 0 && cost[N-1][N-1][d]<answer){
                answer = cost[N-1][N-1][d];
            }
        }
        return answer;
    }
}