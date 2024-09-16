import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static List<Belt> list = new LinkedList<>();
    static int round = 0;

    static void rotateBelt(){
        round++;
        
        list.add(0, list.remove(2*N-1));
        if(list.get(N-1).isRobot){
            list.get(N-1).isRobot = false;
        }
    }

    static void moveRobot(){

        for(int i= N-1;i>0;i--){
            if(list.get(i).isRobot){
                if(!list.get(i+1).isRobot && list.get(i+1).durability>0){
                    list.get(i).isRobot = false;
                    list.get(i+1).isRobot = true;
                    list.get(i+1).durability--;

                    if(list.get(i+1).durability==0){
                        K--;
                    }

                    if(i+1 == N-1){
                        list.get(i+1).isRobot = false;
                    }
                }
            }
        }
    }

    static void addRobot(){
        if(list.get(0).durability>0){
            list.get(0).isRobot = true;
            list.get(0).durability--;
            if(list.get(0).durability==0){
                K--;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<2*N;i++){
            list.add(new Belt(false, Integer.parseInt(st.nextToken()) ));
        }

        while(K>0){
            rotateBelt();
            moveRobot();
            addRobot();
        }
        System.out.println(round);
    }
    static class Belt{
        boolean isRobot;
        int durability;
        Belt(boolean isRobot, int durability){
            this.isRobot = isRobot;
            this.durability = durability;
        }
    }
}