import java.io.*;
import java.util.*;
public class Main {
    static class TotalData implements Comparable<TotalData>{
        int teamId;
        int lastTime;
        int totalScore;
        int cntTry;
        
        public TotalData(int teamId,int lastTime, int totalScore, int cntTry){
            this.teamId = teamId;
            this.lastTime = lastTime;
            this.totalScore = totalScore;
            this.cntTry = cntTry;
        }
        
        @Override
        public int compareTo(TotalData o2){
            if(this.totalScore == o2.totalScore){
                if(this.cntTry == o2.cntTry){
                    return this.lastTime-o2.lastTime;
                }
                return this.cntTry-o2.cntTry;
            }
            return o2.totalScore - this.totalScore;
        }
    }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int T = Integer.parseInt(br.readLine());
    for(int t=0;t<T;t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int cntTeam = Integer.parseInt(st.nextToken());
        int cntQuestion = Integer.parseInt(st.nextToken());
        int teamId = Integer.parseInt(st.nextToken());
        int cntTry = Integer.parseInt(st.nextToken());
        
        int[][] scores = new int[cntTeam+1][cntQuestion+1];
        TotalData[] totalDatas = new TotalData[cntTeam+1];
        
        for(int i=0;i<=cntTeam;i++){
            totalDatas[i] = new TotalData(i, 0, 0, 0);
        }
        
        for(int i=0;i<cntTry;i++){
            st = new StringTokenizer(br.readLine());
            int tId =  Integer.parseInt(st.nextToken());
            int qId =  Integer.parseInt(st.nextToken());
            int s =  Integer.parseInt(st.nextToken());
            
            scores[tId][qId] = Math.max(scores[tId][qId], s);
            totalDatas[tId].lastTime = i;
            totalDatas[tId].cntTry++;
        }
        
        for(int i=1;i<=cntTeam;i++){
            for(int j=1;j<=cntQuestion;j++){
                totalDatas[i].totalScore += scores[i][j];
            }
        }
        
        
        PriorityQueue<TotalData> pq = new PriorityQueue<>();
        
        for(int i=1;i<=cntTeam;i++){
            pq.add(totalDatas[i]);
        }
        
        int rank=1;
        while(!pq.isEmpty()){
            TotalData cur = pq.poll();
            if(cur.teamId==teamId){
                sb.append(rank).append("\n");
                break;
            }else{
                rank++;
            }
        }
    }
    System.out.println(sb);
    
    
    
    
  }
}