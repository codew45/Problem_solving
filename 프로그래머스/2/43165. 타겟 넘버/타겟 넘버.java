class Solution {
    static boolean[] plus;
    static int answer = 0;
    
    static void dfs(int cnt, int numbers[], int target){
        
        if(cnt==plus.length){
            int sum = 0;
            
            for(int i=0; i<plus.length; i++){
                sum += (plus[i] ? 1 : -1)*numbers[i];
            }
            if(sum == target) answer++;
            return;
        }
        
        plus[cnt] = true;
        dfs(cnt+1, numbers, target);
        plus[cnt] = false;
        dfs(cnt+1, numbers, target);
        
        
    }
    
    public int solution(int[] numbers, int target) {
        
        plus = new boolean[numbers.length];
        
        dfs(0, numbers, target);
        
        return answer;
    }
}