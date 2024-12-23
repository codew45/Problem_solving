import java.io.*;
import java.util.*;
public class Main {
    static class Room{
        int minLv;
        int maxLv;
        int maxCnt;
        int curCnt;
        boolean isStarted;
        
        Room(int minLv, int maxLv, int maxCnt, int curCnt, boolean isStarted){
            this.minLv = minLv;
            this.maxLv = maxLv;
            this.maxCnt = maxCnt;
            this.curCnt = curCnt;
            this.isStarted = isStarted;
        }
    }
    
    static class Player implements Comparable<Player>{
        int lv;
        String nickname;
        
        Player(int lv, String nickname){
            this.lv = lv;
            this.nickname = nickname;
        }
        
        @Override
        public int compareTo(Player p){
            return this.nickname.compareTo(p.nickname);
        }
    }
    
    static LinkedList<Room> rooms = new LinkedList<>();
    static LinkedList<LinkedList<Player>> players = new LinkedList<>();
    static int p;
    static int m;
    
    static int isAvailableRoomExist(int lv){
        for(int i=0;i<rooms.size();i++){
            Room room = rooms.get(i);
            if(room.minLv <= lv && room.maxLv >= lv && room.maxCnt>room.curCnt){
                
                return i;
            }
        }
        return -999;
    }
    
    
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    int l = Integer.parseInt(st.nextToken());
    String n = st.nextToken();
    
    rooms.add(new Room(l-10, l+10, m, 1, m > 1 ? false : true));
    
    players.add(new LinkedList<Player>());
    players.get(0).add(new Player(l, n));
    
    for(int i=0;i<p-1;i++){
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        
        int roomId = isAvailableRoomExist(l);
        if(roomId==-999){
            rooms.add(new Room(l-10, l+10, m, 1, m > 1 ? false : true));
            players.add(new LinkedList<Player>());
            players.get(rooms.size()-1).add(new Player(l,n));
            
        }else{
            Room room = rooms.get(roomId);
            room.curCnt++;
            players.get(roomId).add(new Player(l,n));
            if(room.curCnt==room.maxCnt){
                room.isStarted = true;
            }
        }
        
    }
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<rooms.size();i++){
        Room room = rooms.get(i);
        sb.append(room.isStarted ? "Started!" : "Waiting!").append("\n");
        
        List<Player> roomPlayers = players.get(i);
        Collections.sort(roomPlayers);
        
        for(int j=0;j<roomPlayers.size();j++){
            sb.append(roomPlayers.get(j).lv+" "+roomPlayers.get(j).nickname).append("\n");
        }
    }
    System.out.println(sb);
    
  }
}