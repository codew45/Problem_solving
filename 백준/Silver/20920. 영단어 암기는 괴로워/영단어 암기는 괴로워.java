import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Word implements Comparable<Word>{
		String word;
		int len;
		int freq;
		public Word(String word, int len, int freq) {
			this.word = word;
			this.len = len;
			this.freq = freq;
		}
		@Override
		public int compareTo(Word o) {
			if(this.freq!=o.freq) {
				return Integer.compare(o.freq, this.freq);
			}else if(this.len!=o.len) {
				return Integer.compare(o.len, this.len);
			}else {
				return this.word.compareTo(o.word);
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> wordMap = new HashMap<>();
		PriorityQueue<Word> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			if(input.length()>=M) {
				if(wordMap.get(input)!=null) {
					wordMap.put(input, wordMap.get(input)+1);
				}else {
					wordMap.put(input, 1);
				}
			}
		}
		
		for(String word:wordMap.keySet()) {
			pq.add(new Word(word, word.length(), wordMap.get(word)));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
