import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String jh = br.readLine();
		String dr = br.readLine();
		
		if(jh.length()>=dr.length()) {
			System.out.println("go");
		}else {
			System.out.println("no");
		}
	}

}
