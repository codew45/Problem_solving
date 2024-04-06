import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer>map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<26;i++) {
			map.put((char)('A'+i), 0);
		}
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			
			for(int j=0;j<input.length();j++) {
				char c = input.charAt(j);
				int pos = input.length()-j-1;
				map.put(c, map.get(c)+(int)Math.pow(10, pos));
			}
		}
		
		ArrayList<Character> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, (k1, k2)->map.get(k2)-map.get(k1));
		
		HashMap<Character, Integer> weights = new HashMap<>();
		
		// 가중치 부여
		int weight = 9;
		for(char key:keys) {
			weights.put(key, weight);
			weight--;
		}
		
		int answer = 0;
		for(char key:keys) {
			answer += map.get(key)*weights.get(key);
		}
		
		
		System.out.println(answer);
		
	}

}
