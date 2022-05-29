import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] tmp = arr.clone();
        
        Arrays.sort(arr);
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cnt = 0;
        
        for(int i=0;i<N;i++){
            if(!hmap.containsKey(arr[i])){
                hmap.put(arr[i], cnt);
                cnt++;
            }
        }
        for(int i=0;i<N;i++){
            sb.append(hmap.get(tmp[i])).append(" ");
        }
        System.out.print(sb);
    }
}