n = int(input()) 

def recursive_fibo(x):
    global cnt_recursive
    if x==1 or x==2:
        cnt_recursive +=1
        return 1
    return recursive_fibo(x-1)+recursive_fibo(x-2)

def dp_fibo(x):
    global cnt_dp
    dp = [0]*(x+1)
    dp[1] = 1
    dp[2] = 1
    for i in range(3,x+1):
        dp[i] = dp[i-1]+dp[i-2]
        cnt_dp  += 1

cnt_recursive = 0
cnt_dp = 0

recursive_fibo(n)
dp_fibo(n)

print(cnt_recursive, cnt_dp)