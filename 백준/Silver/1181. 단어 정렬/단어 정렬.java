import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0;i<N;i++){
        	String tmp =  br.readLine();
        	
        	if(!list.contains(tmp)) {
        		list.add(tmp);
        	}
        }
        
       
        list.sort((o1, o2)->{
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            else{
                return Integer.compare(o1.length(),o2.length());
            }
        });
        
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }
    }
}