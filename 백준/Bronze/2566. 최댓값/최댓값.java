import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int [][] arr = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        int maxI = 0;
        int maxJ = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(max<arr[i][j]){
                    max = arr[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println(max);
        System.out.printf("%d %d",maxI+1, maxJ+1);
    }
}