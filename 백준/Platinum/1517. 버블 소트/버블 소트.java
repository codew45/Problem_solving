import java.io.*;
import java.util.*;
public class Main{
    static long cnt = 0;
    static long[] sorted;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n];
        sorted = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        mergeSort(arr, 0, n-1);
        
        System.out.println(cnt);
        
    }
    
    static void mergeSort(long[] arr,int low, int high){
        if(low<high){
            int mid =(low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    
    static void merge(long[] arr, int low, int mid, int high){
        int l = low;
        int r = mid+1;
        int idx = low;
        
        while(l <= mid && r <= high){
            if(arr[l]<=arr[r]){
                sorted[idx++] = arr[l++];
            }
            else{
                sorted[idx++] = arr[r++];
                cnt += (r-idx);
            }
        }
        
        
        while(r<=high){
            sorted[idx++] = arr[r++];
        }
        
        
        while(l<=mid){
           sorted[idx++] = arr[l++];
        }
        for(int i=low;i<=high;i++){
            arr[i] = sorted[i];
        }
    }
}