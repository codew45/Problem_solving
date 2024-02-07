import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 방향벡터
		int[] dx = {1,0,-1,0};
		int[] dy = {0,-1,0,1};

		// 배열의 크기, 사과의 개수
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		// 2차원 배열 생성
		int[][] arr = new int[N][N];
		
		// 배열에서 사과가 있는 곳에 1 저장
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r-1][c-1] = 1;
		}
		
		// 방향전환횟수 입력
		int L = Integer.parseInt(br.readLine());
		// 시간, 방향을 맵에 저장
		HashMap<Integer,String> move = new HashMap<>();
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		// 시간은 0초, 오른쪽을 보는 방향으로 시작
		// 뱀의 몸을 -1로 표시할 것임
		int time = 0;
		int dir = 3;
		arr[0][0] = -1;
		
		// 뱀위 몸통 좌표를 넣을 큐
		Queue<Node> snake = new ArrayDeque<>();
		snake.add(new Node(0,0));
		int headX = 0;
		int headY = 0;
		
		while(true) {
			// 해당 time에 방향전환을 해야 한다면 전환해줌
			String nextDir = move.get(time);
			if(nextDir!=null) {
				if(nextDir.equals("D")) dir = (dir+1)%4;
				else if (nextDir.equals("L")) dir = (dir+3)%4;
			}
			
			// 머리를 늘림
			int nx = headX+dx[dir];
			int ny = headY+dy[dir];
			// 범위 내라면
			time++;
			if(0<=nx&&nx<N&&0<=ny&&ny<N) {
				// 뱀의 몸이라면 시간을 출력하고 종료
				if(arr[nx][ny]==-1) {
					System.out.println(time);
					break;
				}
				
				if(arr[nx][ny]==1) {
					snake.add(new Node(nx,ny));
					headX = nx;
					headY = ny;
					arr[nx][ny]=-1;
				}
				else {
					snake.add(new Node(nx,ny));
					headX = nx;
					headY = ny;
					arr[nx][ny]=-1;
					Node n = snake.poll();
					arr[n.x][n.y] = 0;
				}
				
				
			}
			else {
				System.out.println(time);
				break;
			}
		}
		
		
	}
	static class Node{
		int x;
		int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
