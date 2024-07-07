import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;

    static int[] parent;
    static int[] candy;

    static class Group{
        int cntCandy;
        int cntPeople;

        public Group(int cntCandy, int cntPeople){
            this.cntCandy = cntCandy;
            this.cntPeople = cntPeople;
        }
    }

    static void union(int x, int y){
    	int rootX = find(x);
    	int rootY = find(y);
    	
        if(rootX>rootY){
            parent[rootX] = rootY;
        }else{
            parent[rootY] = rootX;
        }
    }

    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        candy = new int[n+1];
        parent = new int[n+1];
        Group[] groups = new Group[n+1];

        int[] dp = new int[k+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            candy[i] = Integer.parseInt(st.nextToken());
            groups[i] = new Group(0,0);
        }

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        for(int i=1;i<=n;i++){
        	int root = find(i);
            groups[root].cntCandy += candy[i];
            groups[root].cntPeople++;
        }
        
        
        for(int i=1;i<=n;i++){
            for(int j=k;j>=groups[i].cntPeople;j--){
            	dp[j] = Math.max(dp[j], dp[j-groups[i].cntPeople]+groups[i].cntCandy);
            }
        }
        System.out.println(dp[k-1]);
        
        

    }
}
