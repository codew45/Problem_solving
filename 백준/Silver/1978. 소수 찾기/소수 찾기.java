import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력받을 숫자의 개수를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // N개의 숫자가 공백으로 나뉘어 입력되므로 스트링토크나이저 사용
        int cnt_prime = 0; // N개의 숫자의 약수를 셀 변수
        for(int i=0;i<N;i++){ // 숫자 N개를 입력받음
            int num = Integer.parseInt(st.nextToken()); // 입력받은 수를 저장
            int cnt_divisor =0; // 약수의 개수를 셀 변수
            for(int j=1;j<=num;j++){
                if(num%j==0) cnt_divisor++; // 1부터 입력받은 수로 나눠가며 나눠떨어질 때마다 약수의 개수를 증가시킴
            }
            if(cnt_divisor==2) cnt_prime++; // 약수의 개수가 2개라면 소수이므로 소수의 개수를 증가시킴
        }
        System.out.print(cnt_prime); // 소수의 개수 출력
        
           }
}