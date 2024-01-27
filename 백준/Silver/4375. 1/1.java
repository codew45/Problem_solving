import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			
			int n = sc.nextInt();
			int cnt = 1;			
			int num = 0;
			
			while(true) {
				num = num*10+1;
				num%=n;
				
				if(num==0) {
					System.out.println(cnt);
					break;
				}
				cnt++;
			}
		}
		sc.close();
	}
}