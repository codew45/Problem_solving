import java.util.Scanner;
public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void perm(int cnt, String permutation) {
		if(cnt==N) {
			int convertedPermutation = Integer.parseInt(permutation);
			if(isPrime(convertedPermutation)) {
				sb.append(convertedPermutation).append("\n");
			}
			return;
		}
		
		for(int i=1;i<=9;i++) {
			int convertedPermutation = Integer.parseInt(permutation+i);
			if(isPrime(convertedPermutation)) {
				perm(cnt+1, permutation+i);
			}
		}
	}
	
	public static boolean isPrime(int number) { 
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		perm(1,"2");
		perm(1,"3");
		perm(1,"5");
		perm(1,"7");
		System.out.println(sb);
	}

}
