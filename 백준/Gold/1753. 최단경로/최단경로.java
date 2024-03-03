import java.io.*;
import java.util.*;
public class Main {
	static int V;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<V+1;i++) list.add(new ArrayList<>());
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, weight));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for(int i=1;i<V+1;i++) {
			if(dist[i]!=Integer.MAX_VALUE) System.out.println(dist[i]);
			else System.out.println("INF");
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.v;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(Node nextNode:list.get(cur)) {
				if(dist[nextNode.v]>dist[cur]+nextNode.weight) {
					dist[nextNode.v] = dist[cur]+nextNode.weight;
					q.add(new Node(nextNode.v, dist[nextNode.v]));
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int v;
		int weight;

		public Node(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}

}
