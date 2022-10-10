import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            
            switch(command){
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
            
        }

        System.out.println(sb);
        
    }
    
    
    static void push_front(int X){
        list.add(0, X);
    }
    static void push_back(int X){
        list.add(X);
    }
    static int pop_front(){
        if(list.isEmpty()) return -1;
        
        int tmp = list.get(0);
        list.remove(0);
        return tmp;
    }
    static int pop_back(){
        if(list.isEmpty()) return -1;
        
        int tmp = list.get(list.size()-1);
        list.remove(list.size()-1);
        return tmp;
    }
    static int size(){
        return list.size();
    }
    static int empty(){
        if(list.isEmpty()) return 1;
        return 0;
    }
    static int front(){
        if(list.isEmpty()) return -1;
        return list.get(0);
    }
    static int back(){
        if(list.isEmpty()) return -1;
        return list.get(list.size()-1);
    }
}