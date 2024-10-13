import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      
      int floor = 1;
      int rooms = 2;
      
      while(N>=rooms){
          rooms += 6*floor;
          floor++;
      }
     
     System.out.println(floor);
  }
}