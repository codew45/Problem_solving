import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder input;
    
    static int find(){
        for(int i=1;i<=Integer.MAX_VALUE;i++){
          String number = String.valueOf(i);
          for(int j=0;j<number.length();j++){
              if(number.charAt(j) == input.charAt(0)){
                  input.delete(0,1);
              }
              if(input.length()==0){
                  return i;
              }
          }
      }
      return -1;
    }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      input = new StringBuilder(br.readLine());
      
      System.out.println(find());
  }
}