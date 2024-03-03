import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		
		ArrayList<Position> stores = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			switch(dir) {
			case 1:
				stores.add(new Position(dir, 0, d));
				break;
			case 2:
				stores.add(new Position(dir, r, d));
				break;
			case 3:
				stores.add(new Position(dir, d, 0));
				break;
			case 4:
				stores.add(new Position(dir, d, c));
				break;
			}
		}
		
		Position dong = stores.get(stores.size()-1);
		stores.remove(stores.size()-1);

		int answer = 0;
		
		for(Position p:stores) {
			int rowDiff = Math.abs(dong.x-p.x);
			int colDiff = Math.abs(dong.y-p.y);
			switch(dong.dir) {
			case 1:
				if(p.dir==2) {
					answer += rowDiff + Math.min(dong.y+p.y, 2*c-dong.y-p.y);
				}else {
					answer += rowDiff+colDiff;
				}
				break;
				
			case 2:
				if(p.dir==1) {
					answer += rowDiff + Math.min(dong.y+p.y, 2*c-dong.y-p.y);
				}else {
					answer += rowDiff+colDiff;
				}
				break;
			case 3:
				if(p.dir==4) {
					answer += c + Math.min(dong.x+p.x, 2*r-dong.x-p.x);
				}else {
					answer += rowDiff+colDiff;
				}
				break;
			case 4:
				if(p.dir==3) {
					answer += c + Math.min(dong.x+p.x, 2*r-dong.x-p.x);
				}else {
					answer += rowDiff+colDiff;
				}
				break;
			}
			
		}
		
		System.out.println(answer);
		
	}
	
	static class Position{
		int dir;
		int x;
		int y;
		public Position(int dir, int x, int y) {
			super();
			this.dir = dir;
			this.x = x;
			this.y = y;
		}
	}
}
